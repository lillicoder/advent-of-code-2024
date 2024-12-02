package com.lillicoder.adventofcode2024.day2

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit tests for [Day2].
 */
internal class Day2Test {
    private val input =
        """
        7 6 4 2 1
        1 2 7 8 9
        9 7 6 2 1
        1 3 2 4 5
        8 6 4 4 1
        1 3 6 7 9
        """.trimIndent()
    private val day2 = Day2()

    @Test
    fun part1() {
        val expected = 2L
        val actual = day2.part1(input)
        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 4L
        val actual = day2.part2(input)
        assertEquals(expected, actual)
    }
}
