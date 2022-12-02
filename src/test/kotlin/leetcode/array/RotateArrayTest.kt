package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RotateArrayTest {

    private val subject = RotateArray()

    @ParameterizedTest
    @MethodSource("arguments")
    fun rotateArray(nums: IntArray, k: Int, output: IntArray) {
        subject.rotate(nums, k)
        assertArrayEquals(output, nums)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, k, output
            return Stream.of(
                Arguments.of(
                    intArrayOf(1, 2, 3, 4, 5),
                    2,
                    intArrayOf(4, 5, 1, 2, 3)
                ),
                Arguments.of(
                    intArrayOf(-4, -1, 0, 3, 10),
                    0,
                    intArrayOf(-4, -1, 0, 3, 10)
                ),
                Arguments.of(
                    intArrayOf(-7),
                    1,
                    intArrayOf(-7)
                ),
                Arguments.of(
                    intArrayOf(-7),
                    0,
                    intArrayOf(-7)
                ),
                Arguments.of(
                    intArrayOf(-4, -3, -2, -1),
                    3,
                    intArrayOf(-3, -2, -1, -4)
                ),
                Arguments.of(
                    intArrayOf(-4, -3, -2, -1),
                    4,
                    intArrayOf(-4, -3, -2, -1)
                ),
                Arguments.of(
                    intArrayOf(-4, -3, -2, -1),
                    6,
                    intArrayOf(-2, -1, -4, -3)
                ),
                Arguments.of(
                    intArrayOf(-7, -5, -3, -2, -1),
                    10,
                    intArrayOf(-7, -5, -3, -2, -1)
                ),
                Arguments.of(
                    intArrayOf(-1),
                    3,
                    intArrayOf(-1)
                ),
                Arguments.of(
                    intArrayOf(-1),
                    2,
                    intArrayOf(-1)
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 4, 5, 6, 7),
                    3,
                    intArrayOf(5, 6, 7, 1, 2, 3, 4)
                ),
                Arguments.of(
                    intArrayOf(-1, -100, 3, 99),
                    2,
                    intArrayOf(3, 99, -1, -100)
                )
            )
        }
    }
}