package com.lillicoder.adventofcode2024.day1

import kotlin.math.abs

fun main() {
    val day1 = Day1()
    val input =
        day1.javaClass.classLoader.getResourceAsStream("input.txt").use {
            it?.reader()?.readText()
        }?.lines() ?: throw IllegalArgumentException("Could not read input.")
    println("The total distance between the lists is ${day1.part1(input)}.")
    println("The similarity score for the lists is ${day1.part2(input)}.")
}

class Day1 {
    fun part1(lines: List<String>): Long {
        val (first, second) = linesToLists(lines)
        return first.zip(second).sumOf {
            abs(it.first - it.second)
        }
    }

    fun part2(lines: List<String>): Long {
        val (first, second) = linesToLists(lines)
        return first.sumOf { id ->
            val frequency = second.count { it == id }
            frequency * id
        }
    }

    private fun linesToLists(lines: List<String>) =
        lines.map { line ->
            val (first, second) = line.split(" ").filter { it.isNotEmpty() }
            first.toLong() to second.toLong()
        }.unzip().let {
            it.first.sorted() to it.second.sorted()
        }
}
