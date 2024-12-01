package wordscramble.components

import java.awt.FlowLayout
import javax.swing.JPanel

class ScrambledLetters(
    word: String,
    onRemoveClick: (Letter) -> Unit
) {
    private var letterList: ArrayList<Letter> = ArrayList()

    var component: JPanel
        private set

    init {
        component = JPanel(FlowLayout())

        val rawLetters = word.toCharArray()
        rawLetters.shuffle()

        for (index in rawLetters.indices) {
            letterList.add(Letter(rawLetters[index], index) {
                val l = letterList.removeAt(index)
                component.remove(index)
                onRemoveClick(l)
            })
        }

        for (letter in letterList)
            component.add(letter.component)
    }

    fun insertLetter(letter: Letter) {
        letterList.add(letter.originalIndex, letter)
    }
}