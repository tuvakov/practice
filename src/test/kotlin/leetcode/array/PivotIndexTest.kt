package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class PivotIndexTest {

    private val subject = PivotIndex()

    @ParameterizedTest
    @MethodSource("arguments")
    fun findDuplicate(nums: IntArray, expected: Int) {
        assertEquals(expected, subject.pivotIndex(nums))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, expected
            return Stream.of(
                Arguments.of(intArrayOf(1, 7, 3, 6, 5, 6), 3),
                Arguments.of(intArrayOf(1, 2, 3), -1),
                Arguments.of(intArrayOf(2, 1, -1), 0),
                Arguments.of(intArrayOf(1, 1, 1), 1),
                Arguments.of(intArrayOf(0, 0, 0), 0)
            )
        }
    }
}