package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class HouseRobberTest {

    private val subject = HouseRobber()

    @ParameterizedTest
    @MethodSource("arguments")
    fun rob(nums: IntArray, output: Int) {
        val result = subject.rob(nums)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 2, 3, 1), 4),
                Arguments.of(intArrayOf(1, 2, 2, 1), 3),
                Arguments.of(intArrayOf(2, 7, 9, 3, 1), 12),
                Arguments.of(intArrayOf(3, 9, 7, 3, 2), 12),
                Arguments.of(intArrayOf(3, 9, 7, 3, 1), 12),
                Arguments.of(intArrayOf(1, 1, 1, 1), 2),
                Arguments.of(intArrayOf(10, 1, 1, 10), 20),
                Arguments.of(intArrayOf(1, 10, 1, 1, 10, 1), 20),
                Arguments.of(intArrayOf(2), 2)
            )
        }
    }
}