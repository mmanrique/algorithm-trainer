package verifications

import file.FileUtils
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess

class SortedVerification {
    companion object {
        //Add any large dataset in this list if you want
        private val testCases: Array<String> = arrayOf(
                "10numbers.txt",
                "1000numbers.txt",
                "100000numbers.txt",
                "500000numbers.txt",
                "1000000numbers.txt",
                "10000000numbers.txt")

        fun sortArray(mainFunction: (Array<Int>) -> Array<Int>) {
            val executor = Executors.newSingleThreadExecutor()
            val tasks = mutableListOf<Callable<Array<Int>>>()
            for (testCase in testCases) {
                println("$testCase: Reading file ")
                val array = FileUtils.readIntArrayFromFile(testCase)

                val task = Callable<Array<Int>> {
                    val currentTimeMillis = System.currentTimeMillis()
                    val invoke: Array<Int> = mainFunction.invoke(array)
                    val nextCurrentTimeMillis = System.currentTimeMillis()
                    val delta = nextCurrentTimeMillis - currentTimeMillis
                    println("$testCase: Took $delta milliseconds")
                    invoke
                }
                println("$testCase: Starting Test")
                val submit: Future<Array<Int>> = executor.submit(task)
                try {
                    val result: Array<Int> = submit.get(1, TimeUnit.MINUTES)
                    val sorted = verifySortedArray(result)
                    if (!sorted) {
                        println("Failed to Sort")
                    }
                } catch (e: Exception) {
                    println("$testCase took too long")
                    exitProcess(1)
                }
            }
            println("SUCCESS")
            executor.shutdown()
        }

        private fun verifySortedArray(array: Array<Int>): Boolean {
            for (index in array.indices) {
                if (array[index] != index + 1) {
                    return false
                }
            }
            return true
        }
    }
}