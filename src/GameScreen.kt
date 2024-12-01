package wordscramble

import wordscramble.components.HealthBar
import wordscramble.components.OrderedLetters
import wordscramble.components.Score
import wordscramble.components.ScrambledLetters
import java.awt.*
import javax.swing.*

class GameScreen(
    private val repository: Repository,
    private val onEnd: () -> Unit
) : JFrame() {

    private var score = Score()
    private var healthBar = HealthBar() { gameOver() }
    private var word: String = repository.nextWord()
    private var orderedLetters = OrderedLetters(word, {}, {})
    private var scrambledLetters = ScrambledLetters(word, {})

    init {
        title = "Word Scramble"
        setSize(800, 600)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setLocationRelativeTo(null)

        val screenPanel = JPanel(GridBagLayout())

        val ordered = orderedLetters.component
        val scrambled = scrambledLetters.component

        val topBarGbc = GridBagConstraints()
        topBarGbc.weightx = 1.0
        topBarGbc.weighty = 0.1
        topBarGbc.gridx = 0
        topBarGbc.gridy = 0
        topBarGbc.fill = GridBagConstraints.HORIZONTAL
        topBarGbc.insets = Insets(50, 50, 50, 50)

        val orderedGbc = GridBagConstraints()
        orderedGbc.weightx = 1.0
        orderedGbc.weighty = 0.45
        orderedGbc.gridx = 0
        orderedGbc.gridy = 1
        orderedGbc.fill = GridBagConstraints.HORIZONTAL

        val scrambledGbc = GridBagConstraints()
        scrambledGbc.weightx = 1.0
        scrambledGbc.weighty = 0.45
        scrambledGbc.gridx = 0
        scrambledGbc.gridy = 2
        scrambledGbc.fill = GridBagConstraints.HORIZONTAL

        screenPanel.add(topBar(), topBarGbc)
        screenPanel.add(ordered, orderedGbc)
        screenPanel.add(scrambled, scrambledGbc)

        add(screenPanel)
    }

    private fun topBar(): JPanel {
        val panel = JPanel(BorderLayout())
        val skip = JButton("Pular")
        skip.addActionListener {
            healthBar.subtractLife()
            // update target word
            // update available letters
        }

        panel.add(healthBar.component, BorderLayout.LINE_START)
        panel.add(score.component, BorderLayout.CENTER)
        panel.add(skip, BorderLayout.LINE_END)

        return panel
    }

    private fun gameOver() {
        JOptionPane.showMessageDialog(
            null,
            "Fim do jogo!\nScore final: ${score.score}"
        )
        onEnd()
    }
}