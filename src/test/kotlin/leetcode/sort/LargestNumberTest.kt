package leetcode.sort

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LargestNumberTest {
    val subject = LargestNumber()

    @ParameterizedTest
    @MethodSource("arguments")
    fun largestNumber(nums: IntArray, expected: String) {
        assertEquals(expected, subject.largestNumber(nums))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1), "1"),
                Arguments.of(intArrayOf(10), "10"),
                Arguments.of(intArrayOf(3, 30, 34, 5, 9), "9534330"),
                Arguments.of(intArrayOf(10, 2), "210"),
                Arguments.of(intArrayOf(10,2,9,39,17), "93921710")
            )
        }
    }
}