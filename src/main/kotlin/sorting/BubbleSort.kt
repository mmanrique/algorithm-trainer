package sorting

import verifications.SortedVerification

class BubbleSort {
    companion object {
        fun bubbleSort(input: Array<Int>): Array<Int> {

            //We swap elements adjacent to each other.
            //After each iteration, the list n-i..n is sorted
            for (i in input.indices) {
                var swapped = false
                for (j in 0 until input.size - i - 1) {
                    //if element j>j+1 we swap them
                    if (input[j] > input[j + 1]) {
                        val temp = input[j]
                        input[j] = input[j + 1]
                        input[j + 1] = temp
                        swapped = true
                    }
                }
                if (!swapped) {
                    println("Finished with i $i")
                    break
                }
            }
            return input
        }
    }

}

fun main() {
    //It took 30 minutes for this to run with 500000numbers.txt
    SortedVerification.sortArray { BubbleSort.bubbleSort(it) }
}