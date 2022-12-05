package leetcode

import leetcode.array.RemoveDuplicatesInSortedArray
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RemoveDuplicatesInSortedArrayTest {

    val subject = RemoveDuplicatesInSortedArray()

    @ParameterizedTest
    @MethodSource("arguments")
    fun removeDuplicates(nums: IntArray, expected: IntArray) {
        val length = subject.removeDuplicates(nums)
        val actual = nums.slice(0 until length).toIntArray()
        println("actual = ${actual.contentToString()}")
        assertArrayEquals(actual, expected)
    }


    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, expected
            return Stream.of(
                Arguments.of(intArrayOf(1, 1, 2), intArrayOf(1, 2)),
                Arguments.of(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4),
                    intArrayOf(0, 1, 2, 3, 4))
            )
        }
    }
}