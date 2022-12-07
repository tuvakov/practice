package leetcode.dfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FloodFillTest {

    private val subject = FloodFill()

    @ParameterizedTest
    @MethodSource("arguments")
    fun floodFill(
        image: Array<IntArray>,
        sr: Int,
        sc: Int,
        color: Int,
        output: Array<IntArray>
    ) {
        val result = subject.floodFill(image, sr, sc, color)
        assertArrayEquals(output, result)
    }

    companion object {

        @JvmStatic
        private fun arguments(): Stream<Arguments> {

            // Image, sr, sc, color, output
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1, 1),
                        intArrayOf(1, 1, 0),
                        intArrayOf(1, 0, 1)
                    ),
                    1, 1, 2,
                    arrayOf(
                        intArrayOf(2, 2, 2),
                        intArrayOf(2, 2, 0),
                        intArrayOf(2, 0, 1)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 0, 0)
                    ),
                    0, 0, 0,
                    arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 0, 0)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1),
                        intArrayOf(0),
                        intArrayOf(1)
                    ),
                    0, 0, 2,
                    arrayOf(
                        intArrayOf(2),
                        intArrayOf(0),
                        intArrayOf(1)
                    )
                )
            )
        }
    }
}