package leetcode.math

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PlusOneTest {

    private val subject = PlusOne()

    @ParameterizedTest
    @MethodSource("arguments")
    fun plusOne(digits: IntArray, output: IntArray) {
        val result = subject.plusOne(digits)
        assertArrayEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(3, 2, 3),
                    intArrayOf(3, 2, 4)
                ),
                Arguments.of(
                    intArrayOf(4, 3, 2, 1),
                    intArrayOf(4, 3, 2, 2)
                ),
                Arguments.of(
                    intArrayOf(9),
                    intArrayOf(1, 0)
                ),
                Arguments.of(
                    intArrayOf(9, 9),
                    intArrayOf(1, 0, 0)
                ),
                Arguments.of(
                    intArrayOf(2, 2, 9),
                    intArrayOf(2, 3, 0)
                )
            )
        }
    }
}