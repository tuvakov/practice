package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MaximumProductSubArrayTest {

    private val subject = MaximumProductSubArray()

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxProductBruteForce(nums: IntArray, output: Int) {
        val result = subject.maxProductBruteForce(nums)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxProduct(nums: IntArray, output: Int) {
        val result = subject.maxProduct(nums)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, output
            return Stream.of(
                Arguments.of(intArrayOf(2, 3, -2, 4), 6),
                Arguments.of(intArrayOf(-2, 1, 1, 1, 1, -3), 6),
                Arguments.of(intArrayOf(1), 1),
                Arguments.of(intArrayOf(2, 0), 2),
                Arguments.of(intArrayOf(-2, 0), 0),
                Arguments.of(intArrayOf(0, -2), 0),
                Arguments.of(intArrayOf(-2, 0, -1), 0),
                Arguments.of(intArrayOf(1, 2, 3, 4), 24),
                Arguments.of(intArrayOf(-1, -2, -3, 100), 600),
                Arguments.of(intArrayOf(-1, -2, -3, -10), 60),
                Arguments.of(intArrayOf(-3, 0, 1, -2), 1),
                Arguments.of(intArrayOf(1, 2, 3, 0, 0, 0, 10), 10)
            )
        }
    }
}