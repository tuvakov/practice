package leetcode.search

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SearchInsertTest {

    private val subject = SearchInsert()

    @ParameterizedTest
    @MethodSource("arguments")
    fun searchInsert(nums: IntArray, target: Int, expected: Int) {
        assertEquals(expected, subject.searchInsert(nums, target))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, target, expected
            return Stream.of(
                Arguments.of(intArrayOf(1, 3, 5, 6), 5, 2),
                Arguments.of(intArrayOf(1, 3, 5, 6), 2, 1),
                Arguments.of(intArrayOf(1, 3, 5, 6), 7, 4),
                Arguments.of(intArrayOf(1, 3, 5, 6), 0, 0)
            )
        }
    }
}
