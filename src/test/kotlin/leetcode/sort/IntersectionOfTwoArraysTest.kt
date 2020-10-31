package leetcode.sort

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class IntersectionOfTwoArraysTest {

    val subject = IntersectionOfTwoArrays()

    @ParameterizedTest
    @MethodSource("arguments")
    fun intersectMap(nums1: IntArray, nums2: IntArray, expected: IntArray) {
        assertArrayEquals(
            subject.intersectMap(nums1, nums2).sortedArray(),
            expected
        )
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun intersectSort(nums1: IntArray, nums2: IntArray, expected: IntArray) {
        assertArrayEquals(
            subject.intersectSort(nums1, nums2).sortedArray(),
            expected
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
                ),
                Arguments.of(
                    intArrayOf(4, 9, 5),
                    intArrayOf(4, 5, 9),
                    intArrayOf(4, 5, 9)
                ),
                Arguments.of(
                    intArrayOf(10),
                    intArrayOf(10),
                    intArrayOf(10)
                ),
                Arguments.of(
                    intArrayOf(10, 12, 13),
                    intArrayOf(8, 9, 7),
                    intArrayOf()
                ),
                Arguments.of(
                    intArrayOf(10, 12, 13),
                    intArrayOf(7, 9, 10),
                    intArrayOf(10)
                ),
                Arguments.of(
                    intArrayOf(1, 1, 1, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1, 1, 1)
                ),
                Arguments.of(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1, 1, 1, 1),
                    intArrayOf(1, 1, 1)
                )
            )
        }
    }
}