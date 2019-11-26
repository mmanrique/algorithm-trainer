package sorting

import verifications.SortedVerification

class InsertionSort {
    companion object {
        fun insertionSort(input: Array<Int>): Array<Int> {
            //For each next element, we find the location where this one belongs.
            //This one iterates the sorted elements on the left of the array
            for (i in input.indices) {
                //Iterate backwards and swap the element
                val item = input[i]
                var j = i - 1
                while (j >= 0 && input[j] > item) {
                    input[j + 1] = input[j]
                    input[j] = item
                    j--
                }
            }
            return input
        }
    }
}

fun main() {
    SortedVerification.sortArray { InsertionSort.insertionSort(it) }
}