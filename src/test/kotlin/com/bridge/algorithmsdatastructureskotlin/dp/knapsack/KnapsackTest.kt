package com.bridge.algorithmsdatastructureskotlin.dp.knapsack

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class KnapsackTest {

    @Test
    fun `Knapsack works with 2 items`() {
        val item1 = KnapsackItem(10, 2)
        val item2 = KnapsackItem(1, 2)
        val items = listOf(item1, item2)
        val knapsack = Knapsack()

        val result = knapsack.solve(Array(2) { i -> items[i] }, 4)

        result.shouldBe(2)
    }

    @Test
    fun `Knapsack works with 4 items`() {
        val item1 = KnapsackItem(1, 2)
        val item2 = KnapsackItem(1, 2)
        val item3 = KnapsackItem(1, 2)
        val item4 = KnapsackItem(1, 2)
        val items = listOf(item1, item2, item3, item4)
        val knapsack = Knapsack()

        val result = knapsack.solve(Array(4) { i -> items[i] }, 4)

        result.shouldBe(8)
    }
}