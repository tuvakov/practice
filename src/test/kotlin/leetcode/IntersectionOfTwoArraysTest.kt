package leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class IntersectionOfTwoArraysTest {

    val subject = IntersectionOfTwoArrays()

    @ParameterizedTest
    @MethodSource("arguments")
    fun intersect(nums1: IntArray, nums2: IntArray, expected: IntArray) {
        assertArrayEquals(
            subject.intersect(nums1, nums2),
            expected.sorted().toIntArray()
        )
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums1, num2, expected
            return Stream.of(
                Arguments.of(
                    intArrayOf(1, 2, 2, 1),
                    intArrayOf(2, 2),
                    intArrayOf(2, 2)
                ),
                Arguments.of(
                    intArrayOf(4, 9, 5),
                    intArrayOf(9, 4, 9, 8, 4),
                    intArrayOf(4, 9)
                )
            )
        }
    }
}