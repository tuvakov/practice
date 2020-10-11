package leetcode.contest.weekly

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MaximalNetworkRankTest {

    val subject = MaximalNetworkRank()

    @ParameterizedTest
    @MethodSource("arguments")
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>, expected: Int) {
        assertEquals(expected, subject.maximalNetworkRank(n, roads))
    }

    companion object {

        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    4, arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 3),
                        intArrayOf(1, 2),
                        intArrayOf(1, 3)
                    ), 4
                ),
                Arguments.of(
                    5, arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 3),
                        intArrayOf(1, 2),
                        intArrayOf(1, 3),
                        intArrayOf(2, 3),
                        intArrayOf(2, 4)
                    ), 5
                ),
                Arguments.of(
                    8, arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(1, 2),
                        intArrayOf(2, 3),
                        intArrayOf(2, 4),
                        intArrayOf(5, 6),
                        intArrayOf(5, 7)
                    ), 5
                )
            )
        }
    }
}