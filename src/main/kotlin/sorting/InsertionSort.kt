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
                for (j in i - 1 downTo 0) {
                    //If it is greater than the element
                    if (input[j] > item) {
                        input[j + 1] = input[j]
                        input[j] = item
                    } else {
                        //Stop when we find an element which is lesser
                        break
                    }
                }
            }
            return input
        }
    }
}

fun main() {
    SortedVerification.sortArray { InsertionSort.insertionSort(it) }
}