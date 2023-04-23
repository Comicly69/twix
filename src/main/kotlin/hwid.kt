import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI
import java.nio.charset.StandardCharsets

fun getHWID(): String {
    val pb = ProcessBuilder("dmidecode", "-s", "system-uuid")
    pb.redirectErrorStream(true)
    val process = pb.start()
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    var line: String?
    var hwid = ""
    while (reader.readLine().also { line = it } != null) {
        hwid += line
    }
    reader.close()
    process.waitFor()
    return hwid.trim()
}

fun sendHWID(hwid: String) {
    val url = URI.create("https://kotlincatcher.requestcatcher.com/test").toURL()
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "POST"
    connection.doOutput = true
    connection.outputStream.write(hwid.toByteArray(StandardCharsets.UTF_8))
    connection.connect()
    connection.inputStream.bufferedReader().use { it.readText() }
    connection.disconnect()
}

fun main() {
    val hwid = getHWID()
    sendHWID(hwid)
    println("Successfully set HWID.")
}
