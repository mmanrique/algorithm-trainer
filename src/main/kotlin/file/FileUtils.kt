package file

import java.io.File

class FileUtils {

    companion object {
        fun writeToFile(content: String, fileName: String) {
            val filePath = "src/main/resources/$fileName"
            val myFile = File(filePath)
            myFile.writeText(content)
        }

        fun readIntArrayFromFile(fileName: String): Array<Int> {
            val readListFromFile: List<Int> = readListFromFile(fileName)
            return readListFromFile.toTypedArray()
        }


        fun readListFromFile(fileName: String): List<Int> {
            val filePath = "src/main/resources/$fileName"
            val myFile = File(filePath)
            return myFile.readText().split(",").map { Integer.parseInt(it) }
        }
    }
}