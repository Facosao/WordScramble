package wordscramble

import java.awt.*
import javax.swing.*

class WelcomeScreen(onClick: () -> Unit) : JFrame() {
    init {
        title = "Word Scramble"
        setSize(300, 300)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setLocationRelativeTo(null) // Center the screen

        val screenPanel = JPanel(GridBagLayout())

        val titleLabel = JLabel("Word Scramble")
        titleLabel.font = Font(null, Font.BOLD, 30)
        titleLabel.horizontalAlignment = JLabel.CENTER
        titleLabel.verticalAlignment = JLabel.CENTER

        val titleLabelGbc = GridBagConstraints()
        titleLabelGbc.gridx = 0
        titleLabelGbc.gridy = 0
        titleLabelGbc.weightx = 1.0
        titleLabelGbc.weighty = 1.0

        val playButton = quickButton(onClick)

        val playButtonGbc = GridBagConstraints()
        playButtonGbc.gridx = 0
        playButtonGbc.gridy = 1
        playButtonGbc.weightx = 1.0
        playButtonGbc.weighty = 1.0

        screenPanel.add(titleLabel, titleLabelGbc)
        screenPanel.add(playButton, playButtonGbc)
        add(screenPanel)
    }

    private fun quickButton(onClick: () -> Unit): JButton {
        val button = JButton("Jogar")
        button.preferredSize = Dimension(100, 50)
        button.addActionListener() { onClick() }

        return button
    }
}