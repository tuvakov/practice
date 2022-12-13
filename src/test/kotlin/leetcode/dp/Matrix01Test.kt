package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Matrix01Test {

    private val subject = Matrix01()

    @ParameterizedTest
    @MethodSource("arguments")
    fun updateMatrix(mat: Array<IntArray>, output: Array<IntArray>) {
        val result = subject.updateMatrix(mat)
        assertArrayEquals(output, result)
    }

    @Test
    fun large() {
        val n = 10000

        val arr = IntArray(n) { 1 }
        arr[arr.lastIndex] = 0

        val resultArr = IntArray(n)
        for (idx in 0 until resultArr.lastIndex) {
            resultArr[idx] = resultArr.lastIndex - idx
        }

        val mat = arrayOf(arr)
        val output = arrayOf(resultArr)

        val result = subject.updateMatrix2(mat)
        assertArrayEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {

            // Matrix, output
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 1),
                        intArrayOf(1, 1, 0),
                        intArrayOf(1, 0, 1)
                    ),
                    arrayOf(
                        intArrayOf(3, 2, 1),
                        intArrayOf(2, 1, 0),
                        intArrayOf(1, 0, 1)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 1, 0),
                        intArrayOf(0, 0, 0)
                    ),
                    arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 1, 0),
                        intArrayOf(0, 0, 0)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 1, 0),
                        intArrayOf(1, 1, 1)
                    ),
                    arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 1, 0),
                        intArrayOf(1, 2, 1)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 1),
                        intArrayOf(1, 0, 1),
                        intArrayOf(1, 1, 1)
                    ),
                    arrayOf(
                        intArrayOf(2, 1, 2),
                        intArrayOf(1, 0, 1),
                        intArrayOf(2, 1, 2)
                    )
                ),
                Arguments.of(
                    arrayOf(intArrayOf(0, 1, 1, 1, 1, 1, 0)),
                    arrayOf(intArrayOf(0, 1, 2, 3, 2, 1, 0))
                )
            )
        }
    }
}