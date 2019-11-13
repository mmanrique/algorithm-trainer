package sorting

import verifications.SortedVerification

class SelectionSort {
    companion object {
        fun selectionSort(input: Array<Int>): Array<Int> {
            for (i in input.indices) {
                //The minimum known is i at the moment.
                var minIndex = i
                //Iterate the array and select the smaller element on the right
                for (j in i until input.size) {
                    if (input[j] < input[minIndex]) {
                        minIndex = j
                    }
                }
                //Swap the minimum element with location in i
                val temp = input[minIndex]
                input[minIndex] = input[i]
                input[i] = temp
            }
            return input
        }
    }
}

fun main() {
    SortedVerification.sortArray { SelectionSort.selectionSort(it) }
}