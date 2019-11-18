package sorting

import verifications.SortedVerification

class HeapSort {

    companion object {
        fun heapSort(array: Array<Int>): Array<Int> {
            //Create a Heap with all the elements. It will be a Max-Heap. Max element at the head of the heap
            //In order to create the heap, we have to maintain the heap status
            //A[i] = parent
            //A[2i+1] = left child
            //A[2i+2]= Right Child.
            //A[i]> left child AND A[i]>right child
            //We verify all non-leaf elements and make sure they satisfy the heap invariant. If they don't you swap them with the larger element
            for (i in (array.size / 2) downTo 0) {
                heapify(array, i, array.size)
            }
            var end: Int = array.size - 1
            //Now, the array is heapified.
            //Start getting the top of the heap and put it at the end of the heap.
            //We stop when there is nothing else to swap

            while (end > 0) {
                val head = array[0]
                array[0] = array[end]
                array[end] = head
                //The element at array[end] is now the largest.
                //the element at array[0] may break the max heap invariant.
                heapify(array, 0, end)
                end--
            }
            //Once the array is empty, return it.
            return array
        }

        private fun parent(i: Int): Int {
            return (i - 1) / 2
        }

        private fun right(i: Int): Int {
            return (i * 2) + 2
        }

        private fun left(i: Int): Int {
            return (i * 2) + 1
        }

        private fun heapify(array: Array<Int>, i: Int, end: Int) {

            var indexLargest = i
            val indexLeft = left(i)
            val indexRight = right(i)
            if (indexLeft < end) {
                //If there is a left child
                if (array[indexLeft] > array[indexLargest]) {
                    indexLargest = indexLeft
                }
            }
            if (indexRight < end) {
                if (array[indexRight] > array[indexLargest]) {
                    indexLargest = indexRight
                }
            }
            if (indexLargest != i) {
                //Swap the largest with i
                val temp = array[i]
                array[i] = array[indexLargest]
                array[indexLargest] = temp
                //At this point, the larger element is located at i
                //We have to make sure we have not broken the heap property.
                heapify(array, indexLargest, end)
            }
        }
    }

}


fun main() {
    SortedVerification.sortArray { HeapSort.heapSort(it) }
}