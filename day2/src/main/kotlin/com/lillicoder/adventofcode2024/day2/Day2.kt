package com.lillicoder.adventofcode2024.day2

import kotlin.math.abs

fun main() {
    val day2 = Day2()
    val input =
        day2.javaClass.classLoader.getResourceAsStream("input.txt").use {
            it?.reader()?.readText()
        }?.lines() ?: throw IllegalArgumentException("Could not read input.")
    println("The number of safe reports is ${day2.part1(input)}.")
    println("The number of safe reports with dampening is ${day2.part2(input)}.")
}

class Day2 {
    fun part1(lines: List<String>): Long {
        val digits =
            lines.map { line ->
                line.split(" ").filter { it.isNotEmpty() }.map { it.toLong() }
            }
        return digits.count { isValidReport(it) }.toLong()
    }

    fun part2(lines: List<String>): Long {
        val digits =
            lines.map { line ->
                line.split(" ").filter { it.isNotEmpty() }.map { it.toLong() }
            }
        return digits.count {
            val isValid = isValidReportWithDampening(it)
            if (!isValid) {
                println("Found invalid report. [report=$it]")
            }

            isValid
        }.toLong()
    }

    private fun isValidReport(report: List<Long>): Boolean {
        // Digits need to be sorted (either low -> high or high -> low) and have a diff of 0 < x < 4
        val isLowHigh = report[0] <= report[1]
        report.windowed(2, 1).forEach { pair ->
            val (first, second) = pair
            val inOrder = if (isLowHigh) first <= second else second < first
            val inRange = abs(first - second) in 1..3
            if (!inOrder || !inRange) return false
        }
        return true
    }

    private fun isValidReportWithDampening(report: List<Long>): Boolean {
        // Let's make the sublists
        val sublists = mutableListOf(report)
        report.forEachIndexed { index, digit ->
            val sub = report.toMutableList().apply { removeAt(index) }
            sublists.add(sub)
        }

        // Dampening allows a report to be valid if a single element being removed
        // makes the report valid by the usual rules
        val validSub =
            sublists.any {
                // This can end up removing the wrong digit, needs to remove the one
                // at the exact index
                isValidReport(it)
            }
        return validSub || isValidReport(report)
    }
}
