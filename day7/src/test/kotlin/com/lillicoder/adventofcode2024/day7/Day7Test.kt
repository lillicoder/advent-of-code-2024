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

package com.lillicoder.adventofcode2024.day7

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit tests for [Day7].
 */
internal class Day7Test {
    private val input =
        """
        190: 10 19
        3267: 81 40 27
        83: 17 5
        156: 15 6
        7290: 6 8 6 15
        161011: 16 10 13
        192: 17 8 14
        21037: 9 7 18 13
        292: 11 6 16 20
        """.trimIndent()
    private val day7 = Day7()

    @Test
    fun part1() {
        val expected = 3749L
        val actual = day7.part1(input)
        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 11387L
        val actual = day7.part2(input)
        assertEquals(expected, actual)
    }
}
