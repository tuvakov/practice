package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

//Arguments.of(intArrayOf(2, 3, -2, 4), 6),

class MaximumSumSubArrayTest {

    private val subject = MaximumSumSubArray()

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxSubArray(nums: IntArray, output: Int) {
        val result = subject.maxSubArray(nums)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, output
            return Stream.of(
                Arguments.of(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
                Arguments.of(intArrayOf(1), 1),
                Arguments.of(intArrayOf(5, 4, -1, 7, 8), 23)
            )
        }
    }
}