package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ThreeSumClosestTest {

    private val subject = ThreeSumClosest()

    @ParameterizedTest
    @MethodSource("arguments")
    fun threeSumClosest(nums: IntArray, target: Int, expected: Int) {
        val result = subject.threeSumClosest(nums, target)
        assertEquals(result, expected)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(-1, 2, 1, -4), 1, 2),
                Arguments.of(intArrayOf(0, 0, 0), 1, 0)
            )
        }
    }
}