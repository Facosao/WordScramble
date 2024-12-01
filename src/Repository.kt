package wordscramble

import java.io.FileReader
import java.util.*

class Repository {
    private var file = Scanner(FileReader("./data/palavras.txt"))
    private val wordList: ArrayList<String> = ArrayList()
    private var index: Int = 0

    init {
        while (file.hasNextLine()) {
            val str = file.nextLine()
            if ((str.length >= 5) && (str.length <= 10)) {
                wordList.add(str)
            }
        }

        wordList.shuffle()
    }

    fun nextWord(): String {
        val word = wordList[index % wordList.size]
        index = (index + 1) % wordList.size
        return word
    }
}