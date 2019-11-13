package sorting

import file.FileUtils

class BubbleSort {
    companion object {
        fun bubbleSort(input: Array<Int>): Array<Int> {

            //We swap elments adjacent to each other.
            //After each iteration, the list n-i..n is sorted
            for (i in input.indices) {
                var swaped = false;
                for (j in 0 until input.size - i - 1) {
                    //if element j>j+1 we swap them
                    if (input[j] > input[j + 1]) {
                        val temp = input[j]
                        input[j] = input[j + 1]
                        input[j + 1] = temp
                        swaped = true
                    }
                }
                if (!swaped) {
                    println("Finished with i $i")
                    break;
                }
            }
            return input
        }
    }

}

fun main() {
    //It took 30 minutes for this to run with 500000numbers.txt
    val array = FileUtils.readIntArrayFromFile("10numbers.txt")
    val currentTimeMillis = System.currentTimeMillis()
    val bubbleSort = BubbleSort.bubbleSort(array)
    val nextCurrentTimeMillis = System.currentTimeMillis()
    val delta = nextCurrentTimeMillis - currentTimeMillis
    println("Took this many millis $delta")
    println(bubbleSort.joinToString(","))
}