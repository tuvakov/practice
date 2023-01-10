package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RotateImageTest {

    private val subject = RotateImage()

    @ParameterizedTest
    @MethodSource("arguments")
    fun rotate(image: Array<IntArray>, output: Array<IntArray>) {
        subject.rotate(image)
        assertArrayEquals(output, image)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1)
                    ),
                    arrayOf(
                        intArrayOf(1)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(4, 5)
                    ),
                    arrayOf(
                        intArrayOf(4, 1),
                        intArrayOf(5, 2)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6),
                        intArrayOf(7, 8, 9)
                    ),
                    arrayOf(
                        intArrayOf(7, 4, 1),
                        intArrayOf(8, 5, 2),
                        intArrayOf(9, 6, 3)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(5, 1, 9, 11),
                        intArrayOf(2, 4, 8, 10),
                        intArrayOf(13, 3, 6, 7),
                        intArrayOf(15, 14, 12, 16)
                    ),
                    arrayOf(
                        intArrayOf(15, 13, 2, 5),
                        intArrayOf(14, 3, 4, 1),
                        intArrayOf(12, 6, 8, 9),
                        intArrayOf(16, 7, 10, 11)
                    )
                )
            )
        }
    }
}