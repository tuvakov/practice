package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ReplaceWithGreatestElementOnRightTest {

    private val subject = ReplaceWithGreatestElementOnRight()

    @ParameterizedTest
    @MethodSource("arguments")
    fun replaceElements(arr: IntArray, expected: IntArray) {
        val result = subject.replaceElements(arr)
        assertArrayEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(17, 18, 5, 4, 6, 1),
                    intArrayOf(18, 6, 6, 6, 1, -1)
                ),
                Arguments.of(
                    intArrayOf(17, 1),
                    intArrayOf(1, -1)
                ),
                Arguments.of(
                    intArrayOf(17),
                    intArrayOf(-1)
                )
            )
        }
    }
}