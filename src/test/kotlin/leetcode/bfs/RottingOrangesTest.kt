package leetcode.bfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RottingOrangesTest {

    private val subject = RottingOranges()

    @ParameterizedTest
    @MethodSource("arguments")
    fun orangesRotting(grid: Array<IntArray>, output: Int) {
        val result = subject.orangesRotting(grid)
        assertEquals(output, result)
    }

    companion object {

        @JvmStatic
        private fun arguments(): Stream<Arguments> {

            // Grid, output
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(2, 1, 1),
                        intArrayOf(1, 1, 0),
                        intArrayOf(0, 1, 1)
                    ),
                    4
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(2, 1, 1),
                        intArrayOf(0, 1, 1),
                        intArrayOf(1, 0, 1)
                    ),
                    -1
                ),
                Arguments.of(
                    arrayOf(intArrayOf(0, 2)), 0
                ),
                Arguments.of(
                    arrayOf(intArrayOf(1)), -1
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(2, 2),
                        intArrayOf(1, 1),
                        intArrayOf(0, 0),
                        intArrayOf(2, 0)
                    ),
                    1
                )
            )
        }
    }
}