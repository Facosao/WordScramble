package wordscramble

import javax.swing.SwingUtilities
import javax.swing.UIManager

fun main() {
    // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

    SwingUtilities.invokeLater {
        val repository = Repository()
        lateinit var welcomeScreen: WelcomeScreen
        lateinit var gameScreen: GameScreen

        val quitLambda: () -> Unit = {
            gameScreen.isVisible = false
            welcomeScreen.isVisible = true
        }

        welcomeScreen = WelcomeScreen {
            welcomeScreen.isVisible = false
            gameScreen = GameScreen(repository, quitLambda)
            gameScreen.isVisible = true
        }

        welcomeScreen.isVisible = true
    }
}