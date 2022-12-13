package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class IsSubsequenceTest {

    private val subject = IsSubsequence()

    @ParameterizedTest
    @MethodSource("arguments")
    fun isSubsequence(s: String, t: String, output: Boolean) {
        assertEquals(output, subject.isSubsequence(s, t))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // s, t, output
            return Stream.of(
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false),
                Arguments.of("abcc", "ahbgdchjhjhjc", true),
                Arguments.of("abcc", "abbc", false),
                Arguments.of("abcc", "ccba", false),
                Arguments.of("c", "a", false)
            )
        }
    }
}