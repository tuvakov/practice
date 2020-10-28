package leetcode.contest.weekly

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ArithmeticSubarraysTest {
    val subject = ArithmeticSubarrays()

    @ParameterizedTest
    @MethodSource("arguments")
    fun checkArithmeticSubarrays(
        nums: IntArray,
        left: IntArray,
        right: IntArray,
        expected: List<Boolean>
    ) {
        assertArrayEquals(
            expected.toTypedArray(),
            subject.checkArithmeticSubarrays(nums, left, right).toTypedArray()
        )
    }

    companion object {

        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(4, 6, 5, 9, 3, 7),
                    intArrayOf(0, 0, 2),
                    intArrayOf(2, 3, 5),
                    listOf(true, false, true)
                ),
                Arguments.of(
                    intArrayOf(
                        -12,
                        -9,
                        -3,
                        -12,
                        -6,
                        15,
                        20,
                        -25,
                        -20,
                        -15,
                        -10
                    ),
                    intArrayOf(0, 1, 6, 4, 8, 7),
                    intArrayOf(4, 4, 9, 7, 9, 10),
                    listOf(false, true, false, false, true, true)
                )
            )
        }
    }
}