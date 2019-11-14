package sorting

import verifications.SortedVerification
import kotlin.random.Random

class QuickSort {
    companion object {
        fun quickSort(array: Array<Int>): Array<Int> {
            //We will call a helper function
            quickSort(array, 0, array.size)
            return array;
        }

        fun rearrange(array: Array<Int>, start: Int, end: Int): Int {
            //Pick a pivot from start to end
            val randomInt = Random.nextInt(end - start)
            //Move the pivot to the end
            val pivotIndex = start + randomInt
            val pivot: Int = array[pivotIndex]
            val temp = array[end - 1]
            array[end - 1] = array[pivotIndex]
            array[pivotIndex] = temp
            //Pivot is now at end-1
            //iterate the array from start to end-1

            //Iterate the array and split it into 3 sections
            //smaller, equal and greater

            var greater = end - 1
            var equal = start

            //start - equal = less
            //equal - i = same value
            //i - greater = unknown
            //greater - end = greater
            var i = start

            while (i < greater) {
                val value = array[i]
                if (value < pivot) {
                    //lesser
                    //Swap the first equal with the current element
                    array[i] = array[equal]
                    array[equal] = value
                    equal++
                    //Now, the element at i is either less or equal, we move to the next element
                    i++

                } else if (value == pivot) {
                    //We don't need to move it as it is in the right place. next to the equals.
                    //Increase i
                    i++
                } else {
                    //greater
                    //swap a[greater] with the current element
                    array[i] = array[greater - 1]
                    array[greater - 1] = value
                    greater--
                    //We just grabbed an unknown, so do not increase i
                }
            }

            //Restore the pivot to the middle
            //Grab a greater and swap it with the pivot
            array[end - 1] = array[greater]
            array[greater] = pivot
            return greater
        }


        fun quickSort(array: Array<Int>, start: Int, end: Int) {
            if (start >= end) {
                return
            }
            val pivotIndex = rearrange(array, start, end)
            //QuickSort left and right
            quickSort(array, start, pivotIndex)
            quickSort(array, pivotIndex + 1, end)
        }
    }
}

fun main() {
    SortedVerification.sortArray { QuickSort.quickSort(it) }
}