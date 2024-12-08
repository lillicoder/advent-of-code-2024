/*
 * Copyright 2024 Scott Weeden-Moody
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this project except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lillicoder.adventofcode2024.day4

import com.lillicoder.adventofcode.kotlin.grids.Grid
import com.lillicoder.adventofcode.kotlin.grids.toGrid
import com.lillicoder.adventofcode.kotlin.io.Resources
import com.lillicoder.adventofcode.kotlin.io.splitNotEmpty
import com.lillicoder.adventofcode.kotlin.math.Direction
import com.lillicoder.adventofcode.kotlin.math.Vertex

fun main() {
    val day4 = Day4()
    val input = Resources.text("input.txt") ?: throw IllegalArgumentException("Could not read input.")
    println("The number of XMAS in the grid is ${day4.part1(input, "XMAS")}.")
    println("The number of X-MAS in the grid is ${day4.part2(input, "MAS")}.")
}

class Day4 {
    fun part1(
        input: String,
        token: String,
    ): Long {
        val grid = input.toGrid { it.toString() }
        return grid.filter {
            token.startsWith(it.value)
        }.sumOf {
            grid.wordSearch(it, token)
        }
    }

    fun part2(
        input: String,
        token: String,
    ): Long {
        if (token.length % 2 == 0) {
            throw IllegalArgumentException(
                "Cannot make an x-search on a token with even number of characters.",
            )
        }

        val center = token[token.length / 2].toString()
        val grid = input.toGrid { it.toString() }
        return grid.filter {
            // Filter for the center value of the X patterns
            center == it.value
        }.count {
            grid.xSearch(it, token)
        }.toLong()
    }

    /**
     * Performs a word search for the given token starting
     * at the given [Vertex] in all directions.
     * @param start Starting vertex.
     * @param token Token to find.
     * @return Number of times token appears from the starting vertex.
     */
    private fun Grid<String>.wordSearch(
        start: Vertex<String>,
        token: String,
    ): Long {
        val directions = Direction.entries.filterNot { it == Direction.UNKNOWN }
        return directions.count { wordSearch(start, token, it) }.toLong()
    }

    /**
     * Performs a word search for the given token starting
     * at the given [Vertex] in the given [Direction].
     * @param start Starting vertex.
     * @param token Token to find.
     * @param direction Direction to search.
     * @return True if the token was found, false otherwise.
     */
    private fun Grid<String>.wordSearch(
        start: Vertex<String>,
        token: String,
        direction: Direction,
    ): Boolean {
        val characters = token.splitNotEmpty("").iterator()

        var next: Vertex<String>? = start
        while (next != null && characters.hasNext()) {
            if (characters.next() != next.value) return false
            next = neighbor(next, direction)
        }

        return !characters.hasNext() // If there are any left we aborted due to null neighbors
    }

    /**
     * Performs an x-search for the given token starting at the given [Vertex]. An
     * x-search only checks diagonal directions for an occurrence of a token, with
     * the given vertex serving as the center character of the token to find.
     * @param start Starting vertex.
     * @param token Token to find.
     * @return Number of times token appears from the starting vertex.
     */
    private fun Grid<String>.xSearch(
        start: Vertex<String>,
        token: String,
        reversed: String = token.reversed(),
    ): Boolean {
        val topLeftDiagonal =
            neighbor(
                start,
                Direction.LEFT_UP,
            )?.value + start.value +
                neighbor(
                    start, Direction.RIGHT_DOWN,
                )?.value
        val topRightDiagonal =
            neighbor(
                start, Direction.LEFT_DOWN,
            )?.value + start.value +
                neighbor(
                    start, Direction.RIGHT_UP,
                )?.value
        return (topLeftDiagonal == token || topLeftDiagonal == reversed) &&
            (topRightDiagonal == token || topRightDiagonal == reversed)
    }
}
