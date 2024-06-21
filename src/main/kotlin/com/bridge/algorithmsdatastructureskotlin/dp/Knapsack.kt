package com.bridge.algorithmsdatastructureskotlin.dp

import com.bridge.algorithmsdatastructureskotlin.dp.knapsack.KnapsackItem
import kotlin.math.max

class Knapsack {

    private lateinit var dp: Array<Array<Int>>

    fun solve(items: Array<KnapsackItem>, maximumKnapsackWeightCapacity: Int): Int {
        dp = Array(items.size + 1) { Array(maximumKnapsackWeightCapacity + 1) { -1 } }
        return solveRecursive(items, maximumKnapsackWeightCapacity, 0)
    }

    private fun solveRecursive(items: Array<KnapsackItem>, remindedKnapsackWeightCapacity: Int, index: Int): Int {
        if (remindedKnapsackWeightCapacity <= 0 || index >= items.size) {
            return 0
        }

        if (dp[index][remindedKnapsackWeightCapacity] > 0) {
            return dp[index][remindedKnapsackWeightCapacity]
        }

        val ifSelectedNewValue =
            items[index].value + solveRecursive(items, remindedKnapsackWeightCapacity - items[index].weight, index + 1)
        val ifSkippedNewValue = solveRecursive(items, remindedKnapsackWeightCapacity, index + 1)

        dp[index][remindedKnapsackWeightCapacity] = max(ifSelectedNewValue, ifSkippedNewValue)
        return dp[index][remindedKnapsackWeightCapacity]
    }
}