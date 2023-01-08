package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MaxStockProfit2Test {

    private val subject = MaxStockProfit2()

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxProfitDp(nums: IntArray, output: Int) {
        assertEquals(output, subject.maxProfitDp(nums))
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxProfitGreedy(nums: IntArray, output: Int) {
        assertEquals(output, subject.maxProfitGreedy(nums))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, output
            return Stream.of(
                Arguments.of(intArrayOf(7, 1, 5, 3, 6, 4), 7),
                Arguments.of(intArrayOf(1, 2, 3, 1, 2, 3, 1, 2, 3), 6),
                Arguments.of(intArrayOf(1), 0),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 4),
                Arguments.of(intArrayOf(1, 1, 1, 1), 0),
                Arguments.of(intArrayOf(7, 6, 4, 3, 1), 0),
                Arguments.of(intArrayOf(7, 7, 7, 7, 15), 8)
            )
        }
    }
}