package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MinCostClimbingStairsTest {

    private val subject = MinCostClimbingStairs()

    @ParameterizedTest
    @MethodSource("arguments")
    fun minCostClimbingStairs(cost: IntArray, output: Int) {
        val result = subject.minCostClimbingStairs(cost)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(10, 15, 20), 15),
                Arguments.of(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1), 6),
                Arguments.of(intArrayOf(1, 1, 1, 1, 1), 2),
                Arguments.of(intArrayOf(1, 1), 1),
                Arguments.of(intArrayOf(1, 1, 3, 0), 1),
                Arguments.of(intArrayOf(1, 1, 2), 1)
            )
        }
    }
}