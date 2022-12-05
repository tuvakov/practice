package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MaxStockProfitTest {

    private val subject = MaxStockProfit()

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxProfit(nums: IntArray, output: Int) {
        assertEquals(subject.maxProfit(nums), output)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, output
            return Stream.of(
                Arguments.of(intArrayOf(7, 1, 5, 3, 6, 4), 5),
                Arguments.of(intArrayOf(7, 6, 4, 3, 1), 0),
                Arguments.of(intArrayOf(1, 1, 1, 1), 0),
                Arguments.of(intArrayOf(1, 2, 3, 4), 3),
                Arguments.of(intArrayOf(1, 2, 3, 4, 1, 2, 3), 3),
                Arguments.of(intArrayOf(1, 2, 3, 4, 1, 2, 3, 7), 6),
                Arguments.of(intArrayOf(2, 1, 1, 1, 1, 6, 2), 5)
            )
        }
    }
}