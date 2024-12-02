package com.lillicoder.adventofcode2024.day1

import kotlin.math.abs

fun main() {
    val day1 = Day1()
    val input =
        day1.javaClass.classLoader.getResourceAsStream("input.txt").use {
            it?.reader()?.readText()
        } ?: throw IllegalArgumentException("Could not read input.")
    println("The total distance between the lists is ${day1.part1(input)}.")
    println("The similarity score for the lists is ${day1.part2(input)}.")
}

class Day1 {
    fun part1(input: String): Long {
        val (first, second) = input.toLists()
        return first.zip(second).sumOf {
            abs(it.first - it.second)
        }
    }

    fun part2(input: String): Long {
        val (first, second) = input.toLists()
        return first.sumOf { id ->
            second.count { it == id } * id
        }
    }

    /**
     * Converts this string of two numbers separated by space into a
     * [Pair] of sorted lists where the first element contains the first
     * numbers of each line and the second element contains the second
     * numbers of each line.
     */
    private fun String.toLists() =
        lines().map { line ->
            val (first, second) = line.split(" ").filter { it.isNotEmpty() }
            first.toLong() to second.toLong()
        }.unzip().let {
            it.first.sorted() to it.second.sorted()
        }
}
