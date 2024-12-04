package com.lillicoder.adventofcode2024.day3

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit tests for [Day3].
 */
internal class Day3Test {
    private val input1 =
        """
        xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
        """.trimIndent()
    private val input2 =
        """
        xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
        """.trimIndent()
    private val day3 = Day3()

    @Test
    fun part1() {
        val expected = 161L
        val actual = day3.part1(input1)
        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 48L
        val actual = day3.part2(input2)
        assertEquals(expected, actual)
    }
}
