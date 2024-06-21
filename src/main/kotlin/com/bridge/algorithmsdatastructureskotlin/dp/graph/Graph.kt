package com.bridge.algorithmsdatastructureskotlin.dp.graph

import java.util.LinkedList

data class Graph(private val edges: Array<IntArray>) {

    fun dfs(root: Int): String {
        val visited = BooleanArray(edges.size)
        val sb = StringBuilder()

        fun dfsRecursive(v: Int): StringBuilder {
            visited[v] = true
            sb.append(v)
            for (neighbor in edges[v]) {
                if (!visited[neighbor]) {
                    dfsRecursive(neighbor)
                }
            }
            return sb
        }

        return dfsRecursive(root).toString()
    }

    fun bfs(root: Int): String {
        val visited = BooleanArray(edges.size)
        val sb = StringBuilder()
        val queue = LinkedList<Int>()
        visited[root] = true
        queue.add(root)

        while (queue.isNotEmpty()) {
            val v = queue.poll()
            sb.append(v)
            for (neighbor in edges[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    queue.add(neighbor)
                }
            }
        }

        return sb.toString()
    }
}