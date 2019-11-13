package arrays

import file.FileUtils
import kotlin.random.Random

class RandomPermutation {
    companion object {
        fun randomPermutation(n: Int): Array<Int> {
            //Fill the array
            val result = Array(n) { it + 1 }
            //Fill the array from the back to the front
            var end: Int = n
            while (end > 0) {
                //Get a random number up to N-1
                val r = Random.nextInt(end)
                //Swap array[end-1] with array[r]
                val temp = result[end - 1]
                result[end - 1] = result[r]
                result[r] = temp
                //Element [end-1] is now set, we go back by 1
                end--
            }
            return result
        }
    }
}

fun main() {
    val randomPermutation = RandomPermutation.randomPermutation(20000000)
    FileUtils.writeToFile(randomPermutation.joinToString(","), "20000000numbers.txt")
}