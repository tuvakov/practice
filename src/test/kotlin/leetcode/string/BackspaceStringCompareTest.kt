package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BackspaceStringCompareTest {

    private val subject = BackspaceStringCompare()

    @ParameterizedTest
    @MethodSource("arguments")
    fun backspaceCompare(s: String, t: String, output: Boolean) {
        val result = subject.backspaceCompare(s, t)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // s, t, output
            return Stream.of(
                Arguments.of("ab#c", "ad#c", true),
                Arguments.of("a#c", "b", false),
                Arguments.of("ab##", "c#d#", true)
            )
        }
    }
}