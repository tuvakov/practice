package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WhereWillBallFallTest {

    private val subject = WhereWillBallFall()

    @ParameterizedTest
    @MethodSource("arguments")
    fun findBall(grid: Array<IntArray>, expected: IntArray) {
        val result = subject.findBall(grid)
        assertArrayEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 1, -1, -1),
                        intArrayOf(1, 1, 1, -1, -1),
                        intArrayOf(-1, -1, -1, 1, 1),
                        intArrayOf(1, 1, 1, 1, -1),
                        intArrayOf(-1, -1, -1, -1, -1)
                    ),
                    intArrayOf(1, -1, -1, -1, -1)
                ),
                Arguments.of(
                    arrayOf(intArrayOf(-1)),
                    intArrayOf(-1)
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 1, 1, 1, 1),
                        intArrayOf(-1, -1, -1, -1, -1, -1),
                        intArrayOf(1, 1, 1, 1, 1, 1),
                        intArrayOf(-1, -1, -1, -1, -1, -1)
                    ),
                    intArrayOf(0, 1, 2, 3, 4, -1)
                )
            )
        }
    }
}