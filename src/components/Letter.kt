package wordscramble.components

import java.awt.Dimension
import javax.swing.JButton

class Letter(
    val letter: Char,
    val originalIndex: Int,
    var onClick: () -> Unit
) {
    var component: JButton
        private set

    init {
        component = JButton(letter.toString())
        val buttonSize = Dimension(50, 50)
        component.preferredSize = buttonSize
        component.maximumSize = buttonSize
        component.addActionListener { onClick() }
    }
}