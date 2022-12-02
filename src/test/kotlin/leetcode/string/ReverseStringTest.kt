package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ReverseStringTest {

    private val subject = ReverseString()

    @ParameterizedTest
    @MethodSource("arguments")
    fun reverseString(s: CharArray, output: CharArray) {
        subject.reverseString(s)
        assertArrayEquals(output, s)
    }

    companion object {

        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // s, output
            return Stream.of(
                Arguments.of("abc".toCharArray(), "cba".toCharArray()),
                Arguments.of("cba".toCharArray(), "abc".toCharArray()),
                Arguments.of("aaaaa".toCharArray(), "aaaaa".toCharArray()),
                Arguments.of(
                    "Hello".toCharArray(),
                    "Hello".reversed().toCharArray()
                ),
                Arguments.of(
                    "Hannah".toCharArray(),
                    "Hannah".reversed().toCharArray()
                ),
                Arguments.of("ab".toCharArray(), "ba".toCharArray()),
                Arguments.of("b".toCharArray(), "b".toCharArray())
            )
        }
    }
}