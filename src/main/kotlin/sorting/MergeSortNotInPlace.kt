package sorting

import file.FileUtils

class MergeSort {

    companion object {
        fun mergeSort(input: Array<Int>): Array<Int> {
            if (input.size <= 1) {
                return input
            }
            val start = 0
            val end = input.size
            //start+end/2 = (2*start + end-start)/2 = start+end-start/2
            val mid = start + (end - start) / 2
            val left = mergeSort(input.copyOfRange(0, mid))
            val right = mergeSort(input.copyOfRange(mid, end))
            //merge left and right
            var leftIndex = 0
            var rightIndex = 0
            var writeIndex = 0
            //while both arrays have not been fully read
            while (leftIndex < left.size && rightIndex < right.size) {
                if (left[leftIndex] < right[rightIndex]) {
                    //Put left into the main array
                    input[writeIndex++] = left[leftIndex++]
                } else {
                    //Put right into the main array
                    input[writeIndex++] = right[rightIndex++]
                }
            }
            //dump the rest into the main input
            while (leftIndex < left.size) {
                input[writeIndex++] = left[leftIndex++]
            }
            while (rightIndex < right.size) {
                input[writeIndex++] = right[rightIndex++]
            }

            return input
        }
    }
}

fun main() {
    val array = FileUtils.readIntArrayFromFile("10numbers.txt")
    val currentTimeMillis = System.currentTimeMillis()
    val mergeSort = MergeSort.mergeSort(array)
    val nextCurrentTimeMillis = System.currentTimeMillis()
    val delta = nextCurrentTimeMillis - currentTimeMillis
    println("Took this many millis $delta")
    for (index in mergeSort.indices) {
        if (mergeSort[index] != index + 1) {
            println("FAILED")
        }
    }
    println(mergeSort.joinToString(","))
}