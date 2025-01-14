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

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit tests for [Day4].
 */
internal class Day4Test {
    private val input =
        """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX
        """.trimIndent()
    private val day4 = Day4()

    @Test
    fun part1() {
        val expected = 18L
        val actual = day4.part1(input, "XMAS")
        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 9L
        val actual = day4.part2(input, "MAS")
        assertEquals(expected, actual)
    }
}
