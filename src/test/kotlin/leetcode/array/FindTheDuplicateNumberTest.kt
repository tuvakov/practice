package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class FindTheDuplicateNumberTest {

    val subject = FindTheDuplicateNumber()

    @ParameterizedTest
    @MethodSource("arguments")
    fun findDuplicate(nums: IntArray, expected: Int) {
        assertEquals(expected, subject.findDuplicate(nums))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, expected
            return Stream.of(
                Arguments.of(intArrayOf(1, 3, 4, 2, 2), 2),
                Arguments.of(intArrayOf(3, 1, 3, 4, 2), 3),
                Arguments.of(intArrayOf(1, 1), 1),
                Arguments.of(intArrayOf(1, 1, 2), 1),
                Arguments.of(intArrayOf(1, 2, 1), 1)
            )
        }
    }
}