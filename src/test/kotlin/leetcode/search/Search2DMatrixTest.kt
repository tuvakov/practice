package leetcode.search

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Search2DMatrixTest {

    private val subject = Search2DMatrix()

    @ParameterizedTest
    @MethodSource("arguments")
    fun searchMatrix(
        matrix: Array<IntArray>,
        target: Int,
        expected: Boolean
    ) {
        val result = subject.searchMatrix(matrix, target)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 3, 5, 7),
                        intArrayOf(10, 11, 16, 20),
                        intArrayOf(23, 30, 34, 60)
                    ), 3, true
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 3, 5, 7),
                        intArrayOf(10, 11, 16, 20),
                        intArrayOf(23, 30, 34, 60)
                    ), 13, false
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1),
                        intArrayOf(10),
                        intArrayOf(23)
                    ), 3, false
                ),
                Arguments.of(
                    arrayOf(intArrayOf(1, 3, 5, 7)), 1, true
                ),
                Arguments.of(
                    arrayOf(intArrayOf(1)), 3, false
                ),
                Arguments.of(
                    arrayOf(intArrayOf(1), intArrayOf(3)), 3, true
                )
            )
        }
    }
}