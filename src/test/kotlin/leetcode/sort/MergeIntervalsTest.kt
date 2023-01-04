package leetcode.sort

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MergeIntervalsTest {

    private val subject = MergeIntervals()

    @ParameterizedTest
    @MethodSource("arguments")
    fun merge(intervals: Array<IntArray>, output: Array<IntArray>) {
        val result = subject.merge(intervals)
        assertArrayEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 3),
                        intArrayOf(2, 6),
                        intArrayOf(8, 10),
                        intArrayOf(15, 18)
                    ),
                    arrayOf(
                        intArrayOf(1, 6),
                        intArrayOf(8, 10),
                        intArrayOf(15, 18)
                    )
                ),
                Arguments.of(
                    arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)),
                    arrayOf(intArrayOf(1, 5))
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 4),
                        intArrayOf(1, 4),
                        intArrayOf(1, 4),
                        intArrayOf(1, 4),
                        intArrayOf(1, 4)
                    ),
                    arrayOf(intArrayOf(1, 4))
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(3, 4),
                        intArrayOf(5, 6),
                        intArrayOf(7, 8),
                        intArrayOf(9, 10)
                    ),
                    arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(3, 4),
                        intArrayOf(5, 6),
                        intArrayOf(7, 8),
                        intArrayOf(9, 10)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 10),
                        intArrayOf(3, 5),
                        intArrayOf(2, 6)
                    ),
                    arrayOf(intArrayOf(1, 10))
                )
            )
        }
    }
}