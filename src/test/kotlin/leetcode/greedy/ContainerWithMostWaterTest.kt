package leetcode.greedy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.Random
import java.util.stream.Stream

class ContainerWithMostWaterTest {

    private val subject = ContainerWithMostWater()

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxArea(heights: IntArray, expected: Int) {
        val result = subject.maxArea(heights)
        assertEquals(expected, result)
    }

    @Test
    fun maxArea_largeInput() {
        val inputFile = "/container-with-most-water/large-input-0.txt"
        val heights = this::class.java.getResource(inputFile)
            .readText()
            .lineSequence()
            .map { it.toInt() }
            .toList()
            .toIntArray()

        val resultFile = "/container-with-most-water/large-input-0-result.txt"
        val expected = this::class.java.getResource(resultFile)
            .readText()
            .toInt()

        val result = subject.maxArea(heights)

        assertEquals(expected, result)
    }

    @Test
    fun maxHeight_random() {
        val random = Random()
        val n = 5
        val heights = IntArray(n)
        repeat(n) { idx ->
            heights[idx] = random.nextInt(10)
        }

        println(heights.contentToString())

        val result = subject.maxArea(heights)
        val expected = subject.maxAreaBruteForce(heights)

        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), 49
                ),
                Arguments.of(
                    intArrayOf(1, 1), 1
                ),
                Arguments.of(
                    intArrayOf(1, 0, 1), 2
                ),
                Arguments.of(
                    intArrayOf(1, 1, 1, 1), 3
                ),
                Arguments.of(
                    intArrayOf(2, 2, 2, 2, 2), 8
                ),
                Arguments.of(
                    intArrayOf(5, 9, 1, 8, 5), 20
                ),
                Arguments.of(
                    intArrayOf(5, 9, 1, 8, 1, 5), 25
                )
            )
        }
    }
}