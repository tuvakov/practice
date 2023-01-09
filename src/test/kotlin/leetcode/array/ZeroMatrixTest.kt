package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ZeroMatrixTest {

    private val subject = ZeroMatrix()

    @ParameterizedTest
    @MethodSource("arguments")
    fun setZeroes(matrix: Array<IntArray>, output: Array<IntArray>) {
        subject.setZeroes(matrix)
        assertArrayEquals(output, matrix)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun setZeroes2(matrix: Array<IntArray>, output: Array<IntArray>) {
        subject.setZeroes2(matrix)
        assertArrayEquals(output, matrix)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(0)
                    ),
                    arrayOf(
                        intArrayOf(0)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 0),
                        intArrayOf(4, 5)
                    ),
                    arrayOf(
                        intArrayOf(0, 0),
                        intArrayOf(4, 0)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 1),
                        intArrayOf(1, 0, 1),
                        intArrayOf(1, 1, 1)
                    ),
                    arrayOf(
                        intArrayOf(1, 0, 1),
                        intArrayOf(0, 0, 0),
                        intArrayOf(1, 0, 1)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 1, 2, 0),
                        intArrayOf(3, 4, 5, 2),
                        intArrayOf(1, 3, 1, 5)
                    ),
                    arrayOf(
                        intArrayOf(0, 0, 0, 0),
                        intArrayOf(0, 4, 5, 0),
                        intArrayOf(0, 3, 1, 0)
                    )
                )
            )
        }
    }
}