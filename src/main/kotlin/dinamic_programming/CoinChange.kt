package dinamic_programming

class CoinChange {

    companion object {
        fun getPossibleValues(value: Int, coins: IntArray): Int {
            val resultMatrix = Array(value + 1) { Array(coins.size) { 0 } }
            for (i in coins.indices) {
                resultMatrix[0][i] = 1
            }
            for (i in 1 until resultMatrix.size) {
                for (j in coins.indices) {
                    val solutionWithCoin = if (i - coins[j] >= 0) resultMatrix[i - coins[j]][j] else 0
                    val solutionWithoutCoin = if (j >= 1) resultMatrix[i][j - 1] else 0
                    resultMatrix[i][j] = solutionWithCoin + solutionWithoutCoin

                }
            }
            return resultMatrix[value][coins.size - 1]
        }
    }

}

fun main(args: Array<String>) {
    val coins: IntArray = intArrayOf(5, 10, 25, 50, 100, 200)
    val currency: Int = 20
    val possibleValues = CoinChange.getPossibleValues(currency, coins)
    //There are 3 options (5,5,5,5), (5,5,10), (10,10)
    println(possibleValues)
}
