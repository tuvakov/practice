package leetcode

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SortColorsTest {
    val subject = SortColors()

    @ParameterizedTest
    @MethodSource("arguments")
    fun sortColors(nums: IntArray) {
        subject.sortColors(nums)
        for (i in 0 until nums.lastIndex) {
            assertTrue(nums[i] <= nums[i + 1])
        }
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums
            return Stream.of(
                Arguments.of(intArrayOf(2, 0, 2, 1, 1, 0)),
                Arguments.of(intArrayOf(2, 0, 1)),
                Arguments.of(intArrayOf(0)),
                Arguments.of(intArrayOf(1))
            )
        }
    }
}