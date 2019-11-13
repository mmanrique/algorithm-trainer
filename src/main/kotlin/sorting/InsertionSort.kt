package sorting

import file.FileUtils

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
                    }
                }
            }
            return input
        }
    }
}

fun main() {
    val array = FileUtils.readIntArrayFromFile("1000numbers.txt")
    val insertionSort = InsertionSort.insertionSort(array)
    println(insertionSort.joinToString(","))
}