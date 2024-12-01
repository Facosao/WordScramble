package wordscramble.components

import java.awt.FlowLayout
import java.awt.Font
import javax.swing.JLabel
import javax.swing.JPanel

private const val BROKEN_HEART_EMOJI = "\uD83D\uDC94"

class HealthBar(private val onDeath: () -> Unit) {
    private var lives = 3
    private val hearts: List<JLabel> = listOf(heart(), heart(), heart())
    var component: JPanel
        private set

    init {
        component = JPanel(FlowLayout())
        component.add(hearts[0])
        component.add(hearts[1])
        component.add(hearts[2])
    }

    fun subtractLife() {
        hearts[lives - 1].text = BROKEN_HEART_EMOJI

        if (lives > 1) {
            lives -= 1
        } else {
            onDeath()
        }
    }

    private fun heart(): JLabel {
        val label = JLabel("❤")
        label.font = Font(null, Font.PLAIN, 15)

        return label
    }
}
