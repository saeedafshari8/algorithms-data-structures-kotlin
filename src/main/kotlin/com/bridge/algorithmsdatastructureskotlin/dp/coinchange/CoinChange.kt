package com.bridge.algorithmsdatastructureskotlin.dp.coinchange

import kotlin.math.min

class CoinChange {

    private lateinit var dp: IntArray
    fun solve(coins: IntArray, amount: Int): Int {
        require(amount >= 0) { "Amount must be bigger than or equals with 0" }

        dp = IntArray(amount + 1) { -1 }

        val result = solveRecursive(coins, amount)
        return if (result > amount) -1 else result
    }

    private fun solveRecursive(coins: IntArray, amount: Int): Int {
        when {

            // The coin is selected and makes the amount zero
            amount == 0 -> return 0

            // The selected coin makes the amount negative
            amount < 0 -> return Int.MAX_VALUE

            dp[amount] != -1 -> return dp[amount]

            else -> {
                var minCoins = Int.MAX_VALUE
                for (coin in coins) {
                    val result = solveRecursive(coins, amount - coin)
                    // To prevent comparing Int.MAX_VALUE with Int.MAX_VALUE
                    if (result < minCoins) {
                        // If one more of the coin is selected the minimum is changed
                        minCoins = min(minCoins, result + 1)
                    }
                }
                dp[amount] = minCoins
                return minCoins
            }
        }
    }
}