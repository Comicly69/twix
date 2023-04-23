import kotlin.concurrent.thread
import kotlin.concurrent.timer
import java.awt.BorderLayout
import java.awt.Font
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel

fun main() {
    println("Starting minecraft...")
    println("Please enter a username: ")
    val username = readlnOrNull()
    println("Username: $username")
    println("init tiles")
    Thread.sleep(1020)
    println("init textures")
    Thread.sleep(1000)
    println("init window")
    Thread.sleep(1050)
    println("loading game")
    val frame = JFrame("Cheese")
    val imageIcon = ImageIcon("/home/max/code/twix/src/assets/cracked.jpg")
    val backgroundLabel = JLabel(imageIcon)
    backgroundLabel.layout = BorderLayout()
    val textLabel = JLabel("Cheese")
    textLabel.font = Font("Arial", Font.BOLD, 36)
    textLabel.horizontalAlignment = JLabel.CENTER
    textLabel.verticalAlignment = JLabel.CENTER
    backgroundLabel.add(textLabel)
    frame.contentPane = backgroundLabel
    frame.setSize(400, 300)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setLocationRelativeTo(null)
    frame.isVisible = true
}