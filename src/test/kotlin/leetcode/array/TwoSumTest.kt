package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TwoSumTest {

    private val subject = TwoSum()

    @ParameterizedTest
    @MethodSource("arguments")
    fun twoSum(nums: IntArray, target: Int, output: IntArray) {
        val result = subject.twoSum(nums, target)
        assertArrayEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, target, output
            return Stream.of(
                Arguments.of(
                    intArrayOf(1, 2, 3, 4, 5),
                    4,
                    intArrayOf(0, 2)
                ),
                Arguments.of(
                    intArrayOf(2, 7, 11, 15),
                    9,
                    intArrayOf(0, 1)
                ),
                Arguments.of(
                    intArrayOf(3, 2, 4),
                    6,
                    intArrayOf(1, 2)
                ),
                Arguments.of(
                    intArrayOf(3, 3),
                    6,
                    intArrayOf(0, 1)
                ),
                Arguments.of(
                    intArrayOf(1, 1, 1, 3, 3, 0, 0),
                    6,
                    intArrayOf(3, 4)
                ),
                Arguments.of(
                    intArrayOf(-1, -2, -3, -4, -5),
                    -8,
                    intArrayOf(2, 4)
                )
            )
        }
    }
}