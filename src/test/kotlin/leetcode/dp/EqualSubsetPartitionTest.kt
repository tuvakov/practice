package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class EqualSubsetPartitionTest {

    private val subject = EqualSubsetPartition()

    private val largeInput = intArrayOf(
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
        100, 100, 100, 99, 97
    )

    @ParameterizedTest
    @MethodSource("arguments")
    fun canPartition(nums: IntArray, output: Boolean) {
        val result = subject.canPartition(nums)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun canPartition2(nums: IntArray, output: Boolean) {
        val result = subject.canPartition2(nums)
        assertEquals(output, result)
    }

    @Test
    fun canPartition_largeInput() {
        val result = subject.canPartition(largeInput)
        assertFalse(result)
    }

    @Test
    fun canPartition2_largeInput() {
        val result = subject.canPartition2(largeInput)
        assertFalse(result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(1, 5, 11, 5), true
                ),
                Arguments.of(
                    intArrayOf(1, 5, 5, 1), true
                ),
                Arguments.of(
                    intArrayOf(4, 4), true
                ),
                Arguments.of(
                    intArrayOf(2), false
                ),
                Arguments.of(
                    intArrayOf(1), false
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 5), false
                ),
                Arguments.of(
                    intArrayOf(2, 3, 5), true
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 4, 5, 6, 7), true
                ),
                Arguments.of(
                    intArrayOf(1, 2, 5), false
                )
            )
        }
    }
}