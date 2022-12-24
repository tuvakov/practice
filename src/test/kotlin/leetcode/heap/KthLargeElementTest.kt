package leetcode.heap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class KthLargeElementTest {

    private val subject = KthLargeElement()

    @ParameterizedTest
    @MethodSource("arguments")
    fun findKthLargest2(nums: IntArray, k: Int, output: Int) {
        val result = subject.findKthLargest(nums, k)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 2, 3, 4, 5, 5), 6, 1),
                Arguments.of(intArrayOf(3, 2, 1, 5, 6, 4), 2, 5),
                Arguments.of(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4, 4),
                Arguments.of(intArrayOf(2), 1, 2),
                Arguments.of(intArrayOf(1, 2, 3), 1, 3)
            )
        }
    }
}