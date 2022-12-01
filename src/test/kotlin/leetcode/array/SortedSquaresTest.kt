package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SortedSquaresTest {

    private val subject = SortedSquares()

    @ParameterizedTest
    @MethodSource("arguments")
    fun sortedSquares(nums: IntArray, output: IntArray) {
        assertArrayEquals(output, subject.sortedSquares(nums))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, output
            return Stream.of(
                Arguments.of(
                    intArrayOf(1, 2, 3, 4, 5),
                    intArrayOf(1, 4, 9, 16, 25)
                ),
                Arguments.of(
                    intArrayOf(-4, -1, 0, 3, 10),
                    intArrayOf(0, 1, 9, 16, 100)
                ),
                Arguments.of(
                    intArrayOf(-7, -3, 2, 3, 11),
                    intArrayOf(4, 9, 9, 49, 121)
                ),
                Arguments.of(
                    intArrayOf(-4, -3, -2, -1, 0),
                    intArrayOf(0, 1, 4, 9, 16)
                ),
                Arguments.of(
                    intArrayOf(-7, -5, -3, -2, -1),
                    intArrayOf(1, 4, 9, 25, 49)
                ),
                Arguments.of(
                    intArrayOf(0),
                    intArrayOf(0)
                )
            )
        }
    }
}