package leetcode.contest.weekly

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SlowestKeyTest {
    val subject = SlowestKey()

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxDepth(arr: IntArray, s: String, expected: Char) {
        assertEquals(expected, subject.slowestKey(arr, s))
    }

    companion object {

        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(12, 23, 36, 46, 62), "spuda", 'a'),
                Arguments.of(intArrayOf(9, 29, 49, 50), "cbcd", 'c')
            )
        }
    }
}