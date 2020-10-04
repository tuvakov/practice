package leetcode.contest.weekly

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SpecialArrayWithXElementsGreaterThanOrEqualXTest {

    val subject = SpecialArrayWithXElementsGreaterThanOrEqualX()

    @ParameterizedTest
    @MethodSource("arguments")
    fun specialArray(nums: IntArray, expected: Int) {
        assertEquals(expected, subject.specialArray(nums))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, expected
            return Stream.of(
                Arguments.of(intArrayOf(3, 5), 2),
                Arguments.of(intArrayOf(0, 0), -1),
                Arguments.of(intArrayOf(1), 1),
                Arguments.of(intArrayOf(4, 4, 4, 4), 4),
                Arguments.of(intArrayOf(0, 4, 3, 0, 4), 3),
                Arguments.of(intArrayOf(3, 6, 7, 7, 0), -1),
                Arguments.of(intArrayOf(1, 0, 0, 6, 4, 9), 3),
                Arguments.of(intArrayOf(3, 6, 7, 7, 7, 7, 7, 7, 7, 0), 7)
            )
        }
    }
}