package wordscramble.components

import java.awt.BorderLayout
import java.awt.Color
import java.awt.Component
import java.awt.Dimension
import java.awt.FlowLayout
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel

class OrderedLetters(
    private val answer: String,
    val onRemoveClick: (Letter) -> Unit,
    val onCorrectAnswer: () -> Unit
) {
    private val componentList: ArrayList<Component> = ArrayList()
    private val letterList: ArrayList<Letter> = ArrayList()

    var component: JPanel = JPanel(FlowLayout())
        private set

    init {
        println("Word = $answer")
        for (i in answer.indices) {
            component.add(emptyBlock())
        }
    }

    fun insertLetter(letter: Letter) {
        letterList.add(letter)
        componentList[letterList.size - 1] = letter.component

        letter.onClick = {

        }

        isCorrectAnswer()
    }

    private fun isCorrectAnswer() {
        if (letterList.size == answer.length) {
            val folded = letterList.fold("") { acc, l -> acc + l.letter }
            if (folded == answer) {
                onCorrectAnswer()
            }
        }
    }

    private fun emptyBlock(): JButton {
//        val label = JLabel()
//        label.background = Color.BLUE
//        label.isOpaque = true
//        label.preferredSize = Dimension(50, 50)
//        label.border = BorderFactory.createLineBorder(Color.BLACK, 10, true)
//        return label

        val button = JButton()
        button.preferredSize = Dimension(50, 50)
        button.setEnabled(false)

        return button
    }
}