package searching

import file.FileUtils

class LinearSearch {
    companion object {
        fun linearSearch(value: Int, input: Array<Int>): Int {
            for (i in input.indices) {
                if (input[i] == value) {
                    return i
                }

            }
            return -1
        }
    }
}

fun main() {
    val input = FileUtils.readIntArrayFromFile("1000numbers.txt")
    val linearSearch = LinearSearch.linearSearch(768, input)
    print(linearSearch)
}