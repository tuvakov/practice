package leetcode.stack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ValidParenthesesTest {

    private val subject = ValidParentheses()

    @ParameterizedTest
    @MethodSource("arguments")
    fun isValid(s: String, output: Boolean) {
        val result = subject.isValid(s)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("[][][][]", true),
                Arguments.of("()[]{})", false),
                Arguments.of("()[]{}", true),
                Arguments.of("()", true),
                Arguments.of("))))", false),
                Arguments.of("([{}])", true),
                Arguments.of("(]", false)
            )
        }
    }
}