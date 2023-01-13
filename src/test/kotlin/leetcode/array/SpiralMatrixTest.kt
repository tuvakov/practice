package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SpiralMatrixTest {

    private val subject = SpiralMatrix()

    @ParameterizedTest
    @MethodSource("arguments")
    fun spiralOrder(matrix: Array<IntArray>, output: List<Int>) {
        val result = subject.spiralOrder(matrix)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun spiralOrder2(matrix: Array<IntArray>, output: List<Int>) {
        val result = subject.spiralOrder2(matrix)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf(intArrayOf(0)),
                    listOf(0)
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6),
                        intArrayOf(7, 8, 9)
                    ),
                    listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
                ),
                Arguments.of(
                    arrayOf(intArrayOf(1, 2, 3)),
                    listOf(1, 2, 3)
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1),
                        intArrayOf(4),
                        intArrayOf(7)
                    ),
                    listOf(1, 4, 7)
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 2, 3, 4),
                        intArrayOf(5, 6, 7, 8),
                        intArrayOf(9, 10, 11, 12)
                    ),
                    listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
                )
            )
        }
    }
}