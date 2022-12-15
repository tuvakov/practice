package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class IsIsomorphicTest {

    private val subject = IsIsomorphic()

    @ParameterizedTest
    @MethodSource("arguments")
    fun isIsomorphic(s: String, t: String, output: Boolean) {
        assertEquals(output, subject.isIsomorphic(s, t))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // s, t, output
            return Stream.of(
                Arguments.of("abc", "abc", true),
                Arguments.of("cba", "abc", true),
                Arguments.of("c", "a", true),
                Arguments.of("egg", "add", true),
                Arguments.of("paper", "title", true),
                Arguments.of("foo", "bar", false),
                Arguments.of("papel", "title", true),
                Arguments.of("paper", "titre", true),
                Arguments.of("bbbaaaba", "aaabbbba", false),
                Arguments.of("bababa", "cdcdcd", true),
                Arguments.of("bababa", "cdcdce", false),
                Arguments.of("badc", "baba", false)
            )
        }
    }
}