package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MergeSortedArraysTest {

    private val subject = MergeSortedArrays()

    @ParameterizedTest
    @MethodSource("arguments")
    fun merge(
        nums1: IntArray,
        m: Int,
        nums2: IntArray,
        n: Int,
        output: IntArray
    ) {
        subject.merge(nums1, m, nums2, n)
        assertArrayEquals(output, nums1)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(1, 2, 3, 0, 0, 0),
                    3,
                    intArrayOf(2, 5, 6),
                    3,
                    intArrayOf(1, 2, 2, 3, 5, 6)
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 0, 0, 0),
                    3,
                    intArrayOf(4, 5, 6),
                    3,
                    intArrayOf(1, 2, 3, 4, 5, 6)
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 0, 0, 0),
                    3,
                    intArrayOf(1, 1, 1),
                    3,
                    intArrayOf(1, 1, 1, 1, 2, 3)
                ),
                Arguments.of(
                    intArrayOf(1, 1, 1, 0, 0, 0),
                    3,
                    intArrayOf(4, 5, 6),
                    3,
                    intArrayOf(1, 1, 1, 4, 5, 6)
                ),
                Arguments.of(
                    intArrayOf(1, 20, 300, 0, 0, 0),
                    3,
                    intArrayOf(2, 10, 600),
                    3,
                    intArrayOf(1, 2, 10, 20, 300, 600)
                ),
                Arguments.of(
                    intArrayOf(1),
                    1,
                    intArrayOf(),
                    0,
                    intArrayOf(1)
                ),
                Arguments.of(
                    intArrayOf(0),
                    0,
                    intArrayOf(1),
                    1,
                    intArrayOf(1)
                ),
                Arguments.of(
                    intArrayOf(1, 1, 1, 0, 0, 0),
                    3,
                    intArrayOf(1, 1, 1),
                    3,
                    intArrayOf(1, 1, 1, 1, 1, 1)
                ),
                Arguments.of(
                    intArrayOf(4, 5, 6, 0, 0, 0),
                    3,
                    intArrayOf(1, 2, 3),
                    3,
                    intArrayOf(1, 2, 3, 4, 5, 6)
                ),
                Arguments.of(
                    intArrayOf(1, 2, 4, 5, 6, 0),
                    5,
                    intArrayOf(3),
                    1,
                    intArrayOf(1, 2, 3, 4, 5, 6)
                ),
                Arguments.of(
                    intArrayOf(-1, 0, 0, 3, 3, 3, 0, 0, 0),
                    6,
                    intArrayOf(1, 2, 2),
                    3,
                    intArrayOf(-1, 0, 0, 1, 2, 2, 3, 3, 3)
                )
            )
        }
    }
}