package com.lillicoder.adventofcode2024.day1

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit tests for [Day1].
 */
internal class Day1Test {
    private val input =
        """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
        """.trimIndent()
    private val day1 = Day1()

    @Test
    fun part1() {
        val expected = 11L
        val actual = day1.part1(input)
        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 31L
        val actual = day1.part2(input)
        assertEquals(expected, actual)
    }
}
