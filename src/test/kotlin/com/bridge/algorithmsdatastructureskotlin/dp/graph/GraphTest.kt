package com.bridge.algorithmsdatastructureskotlin.dp.graph

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class GraphTest {

    @Test
    fun `DFS works`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf(),
            intArrayOf()
        )
        val graph = Graph(edges)

        val actual = graph.dfs(0)

        actual.shouldBe("01324")
    }

    @Test
    fun `BFS works`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf(),
            intArrayOf()
        )
        val graph = Graph(edges)

        val actual = graph.bfs(0)
        actual.shouldBe("01234")
    }
}