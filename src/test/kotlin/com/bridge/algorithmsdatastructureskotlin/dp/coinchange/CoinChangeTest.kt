package com.bridge.algorithmsdatastructureskotlin.dp.coinchange

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CoinChangeTest {

    @Test
    fun `CoinChange works with 1 coins`() {
        val coins = intArrayOf(1)
        val amount = 25
        val coinChange = CoinChange()

        val minimumNumberOfCoins = coinChange.solve(coins, amount)

        minimumNumberOfCoins.shouldBe(25)
    }

    @Test
    fun `CoinChange works with 2 coins`() {
        val coins = intArrayOf(1, 5)
        val amount = 25
        val coinChange = CoinChange()

        val minimumNumberOfCoins = coinChange.solve(coins, amount)

        minimumNumberOfCoins.shouldBe(5)
    }

    @Test
    fun `CoinChange works with 5 coins`() {
        val coins = intArrayOf(1, 5, 10, 20, 50)
        val amount = 1249
        val coinChange = CoinChange()

        val minimumNumberOfCoins = coinChange.solve(coins, amount)

        minimumNumberOfCoins.shouldBe(31)
    }

    @Test
    fun `no solution with 1 coin`() {
        val coins = intArrayOf(2)
        val amount = 11
        val coinChange = CoinChange()

        val minimumNumberOfCoins = coinChange.solve(coins, amount)

        minimumNumberOfCoins.shouldBe(-1)
    }
}