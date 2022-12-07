package leetcode.dfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class NumberOfIslandsTest {

    private val subject = NumberOfIslands()

    @ParameterizedTest
    @MethodSource("arguments")
    fun numIslands(grid: Array<CharArray>, output: Int) {
        val result = subject.numIslands(grid)
        assertEquals(result, output)
    }

    companion object {

        @JvmStatic
        private fun arguments(): Stream<Arguments> {

            // Image, output
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        charArrayOf('1', '1', '1', '1', '0'),
                        charArrayOf('1', '1', '0', '1', '0'),
                        charArrayOf('1', '1', '0', '0', '0'),
                        charArrayOf('0', '0', '0', '0', '0')
                    ),
                    1
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('1', '1', '0', '0', '0'),
                        charArrayOf('1', '1', '0', '0', '0'),
                        charArrayOf('0', '0', '1', '0', '0'),
                        charArrayOf('0', '0', '0', '1', '1')
                    ),
                    3
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('1', '1', '0'),
                        charArrayOf('1', '1', '0'),
                        charArrayOf('0', '0', '1')
                    ),
                    2
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('1', '1', '0'),
                        charArrayOf('0', '1', '0'),
                        charArrayOf('0', '0', '1')
                    ),
                    2
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('1', '0', '0'),
                        charArrayOf('0', '1', '0'),
                        charArrayOf('0', '0', '1')
                    ),
                    3
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('1', '0', '0'),
                        charArrayOf('1', '0', '0'),
                        charArrayOf('1', '0', '0')
                    ),
                    1
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('1'),
                        charArrayOf('1'),
                        charArrayOf('1')
                    ),
                    1
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('0'),
                        charArrayOf('0'),
                        charArrayOf('0')
                    ),
                    0
                )
            )
        }
    }
}