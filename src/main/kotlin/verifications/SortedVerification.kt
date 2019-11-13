package verifications

import file.FileUtils
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess

class SortedVerification {
    companion object {
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
                val task = Callable<Array<Int>> {
                    println("Testing with $testCase")
                    val currentTimeMillis = System.currentTimeMillis()
                    val invoke: Array<Int> = mainFunction.invoke(FileUtils.readIntArrayFromFile(testCase))
                    val nextCurrentTimeMillis = System.currentTimeMillis()
                    val delta = nextCurrentTimeMillis - currentTimeMillis
                    val sorted = verifySortedArray(invoke)
                    if (!sorted) {
                        println("Failed to Sort")
                    } else {
                        println("$testCase: Took this many millis $delta")
                    }
                    invoke
                }

                val submit: Future<Array<Int>> = executor.submit(task)
                try {
                    submit.get(1, TimeUnit.MINUTES)
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