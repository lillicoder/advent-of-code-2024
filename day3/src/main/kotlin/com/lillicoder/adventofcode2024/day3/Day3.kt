package com.lillicoder.adventofcode2024.day3

fun main() {
    val day3 = Day3()
    val input =
        day3.javaClass.classLoader.getResourceAsStream("input.txt").use {
            it?.reader()?.readText()
        } ?: throw IllegalArgumentException("Could not read input.")
    println("The sum of all multiply instruction results is ${day3.part1(input)}.")
    println("The sum of all multiply instructions w/ do()/don't() clauses is ${day3.part2(input)}.")
}

class Day3 {
    fun part1(input: String) =
        input.parseMuls().sumOf {
            it.value.mul()
        }

    fun part2(input: String): Long {
        val segments = input.split("do()")
        return segments.sumOf { segment ->
            // Only process instructions until next don't()
            segment.substringBefore(
                "don\'t()",
            ).parseMuls().sumOf {
                it.value.mul()
            }
        }
    }

    /**
     * Computes the mul instruction for this string.
     * @return Product of this instruction's operands.
     */
    private fun String.mul(): Long {
        // Expected format: mul(xxx,yyy)
        val pattern = "\\d{1,3}".toRegex()
        val matches = pattern.findAll(this)
        val first = matches.firstOrNull()?.value?.toLong() ?: 0L
        val second = matches.lastOrNull()?.value?.toLong() ?: 0L
        return first * second
    }

    /**
     * Gets all [MatchResult] of mul instructions from this string.
     * @return Mul instruction matches.
     */
    private fun String.parseMuls() = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex().findAll(this)
}
