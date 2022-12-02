package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MoveZerosTest {

    private val subject = MoveZeros()

    @ParameterizedTest
    @MethodSource("arguments")
    fun moveZeros(nums: IntArray, output: IntArray) {
        subject.moveZeros(nums)
        assertArrayEquals(output, nums)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, output
            return Stream.of(
                Arguments.of(
                    intArrayOf(1, 7, 3, 6, 0, 0),
                    intArrayOf(1, 7, 3, 6, 0, 0)
                ),
                Arguments.of(
                    intArrayOf(0, 0, 1, 7, 3, 6),
                    intArrayOf(1, 7, 3, 6, 0, 0)
                ),
                Arguments.of(
                    intArrayOf(1, 2, 0, 0, 3, 6),
                    intArrayOf(1, 2, 3, 6, 0, 0)
                ),
                Arguments.of(
                    intArrayOf(0),
                    intArrayOf(0)
                ),
                Arguments.of(
                    intArrayOf(0, 2),
                    intArrayOf(2, 0)
                ),
                Arguments.of(
                    intArrayOf(0, 1, 0, 3, 12),
                    intArrayOf(1, 3, 12, 0, 0)
                ),
                Arguments.of(
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0)
                ),
                Arguments.of(
                    intArrayOf(0, 0, 0, 0, 1),
                    intArrayOf(1, 0, 0, 0, 0)
                ),
                Arguments.of(
                    intArrayOf(0, 1, 0, 1),
                    intArrayOf(1, 1, 0, 0)
                ),
                Arguments.of(
                    intArrayOf(1, 0, 1, 0),
                    intArrayOf(1, 1, 0, 0)
                )
            )
        }
    }
}