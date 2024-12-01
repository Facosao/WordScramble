package wordscramble.components

import java.awt.Font
import javax.swing.JLabel
import javax.swing.SwingConstants

class Score {
    var score: Int = 0
        private set

    var component: JLabel
        private set

    init {
        component = JLabel("Score: $score")
        component.font = Font(null, Font.PLAIN, 20)
        component.horizontalAlignment = JLabel.CENTER
    }

    fun increaseScore(word: String) {
        score += word.length * 5
        component.text = "Score: $score"
    }
}