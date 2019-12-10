package sorting

import file.FileUtils
import verifications.SortedVerification

class CountingSort {
    companion object {
        fun countingSort(input: Array<Int>, max: Int): Array<Int> {
            //We need a max value
            //We start from 0 to max inclusive
            val helper: Array<Int> = Array(max + 1) { 0 }
            for (i in input.indices) {
                helper[input[i]]++
            }

            //We sum previous values.
            for (i in 1 until helper.size) {
                helper[i] += helper[i - 1]
            }
            //Now we know where to place each number
            //We reiterate the original array and place each item at it's new location
            val result: Array<Int> = Array(input.size) { 0 }
            for (i in input) {
                result[helper[i] - 1] = i
                helper[i]--
            }
            return result
        }
    }
}

fun main() {
    val readIntArrayFromFile = FileUtils.readIntArrayFromFile("10000000numbers.txt")
    val countingSort = CountingSort.countingSort(readIntArrayFromFile, 10000000)
    val verifySortedArray = SortedVerification.verifySortedArray(countingSort)
    println(verifySortedArray)
}