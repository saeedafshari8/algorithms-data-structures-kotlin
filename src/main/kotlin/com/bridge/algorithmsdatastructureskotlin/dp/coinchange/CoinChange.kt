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

            amount == 0 -> return 0

            amount < 0 -> return Int.MAX_VALUE

            dp[amount] != -1 -> return dp[amount]

            else -> {
                var minCoins = Int.MAX_VALUE
                for (coin in coins) {
                    val result = solveRecursive(coins, amount - coin)
                    if (result < minCoins) {
                        minCoins = min(minCoins, result + 1)
                    }
                }
                dp[amount] = minCoins
                return minCoins
            }
        }
    }
}