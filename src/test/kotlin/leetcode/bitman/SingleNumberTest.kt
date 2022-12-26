package leetcode.bitman

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SingleNumberTest {

    private val subject = SingleNumber()

    @ParameterizedTest
    @MethodSource("arguments")
    fun singleNumber(nums: IntArray, output: Int) {
        val result = subject.singleNumber(nums)
        assertEquals(output, result)
    }

    @Test
    fun single() {
        val result = subject.singleNumber(intArrayOf(1, 3, 2, 1, 3))
        assertEquals(2, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, k, output
            return Stream.of(
                Arguments.of(intArrayOf(1, 2, 1, 2, 3), 3),
                Arguments.of(intArrayOf(2, 2, 1), 1),
                Arguments.of(intArrayOf(4, 1, 2, 1, 2), 4),
                Arguments.of(intArrayOf(1), 1),
                Arguments.of(intArrayOf(1, 1, 1, 1, 1, 1, 2), 2),
                Arguments.of(intArrayOf(1, 1, 2, 2, 100, 3, 3, 300, 300), 100)
            )
        }
    }
}