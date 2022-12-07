package leetcode.dfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MaxAreaOfIslandTest {

    private val subject = MaxAreaOfIsland()

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxAreaOfIsland(grid: Array<IntArray>, output: Int) {
        val result = subject.maxAreaOfIsland(grid)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            // grid, output
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 1, 1, 0),
                        intArrayOf(1, 1, 0, 1, 0),
                        intArrayOf(1, 1, 0, 0, 0),
                        intArrayOf(0, 0, 0, 0, 0)
                    ),
                    9
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 0, 0, 0),
                        intArrayOf(1, 1, 0, 0, 0),
                        intArrayOf(0, 0, 1, 0, 0),
                        intArrayOf(0, 0, 0, 1, 1)
                    ),
                    4
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 0),
                        intArrayOf(1, 1, 0),
                        intArrayOf(0, 0, 1)
                    ),
                    4
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 0),
                        intArrayOf(0, 1, 0),
                        intArrayOf(0, 0, 1)
                    ),
                    3
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 0, 0),
                        intArrayOf(0, 1, 0),
                        intArrayOf(0, 0, 1)
                    ),
                    1
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 0, 0),
                        intArrayOf(1, 0, 0),
                        intArrayOf(1, 0, 0)
                    ),
                    3
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1),
                        intArrayOf(1),
                        intArrayOf(1)
                    ),
                    3
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0),
                        intArrayOf(0),
                        intArrayOf(0)
                    ),
                    0
                )
            )
        }
    }
}