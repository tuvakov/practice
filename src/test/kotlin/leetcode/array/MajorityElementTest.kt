package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MajorityElementTest {

    private val subject = MajorityElement()

    @ParameterizedTest
    @MethodSource("arguments")
    fun majorityElementSort(nums: IntArray, output: Int) {
        val result = subject.majorityElementSort(nums)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun majorityElementHashTable(nums: IntArray, output: Int) {
        val result = subject.majorityElementHashTable(nums)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun majorityElementBoyerMoore(nums: IntArray, output: Int) {
        val result = subject.majorityElementBoyerMoore(nums)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // nums, expected
            return Stream.of(
                Arguments.of(intArrayOf(3, 2, 3), 3),
                Arguments.of(intArrayOf(2, 2, 1, 1, 1, 2, 2), 2),
                Arguments.of(intArrayOf(2), 2),
                Arguments.of(intArrayOf(3, 3, 4), 3),
                Arguments.of(intArrayOf(6, 5, 5), 5)
            )
        }
    }
}