package leetcode.string

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LongestSubstringWithoutRepeatingCharactersTest {

    val subject = LongestSubstringWithoutRepeatingCharacters()

    @ParameterizedTest
    @MethodSource("arguments")
    fun lengthOfLongestSubstring(s: String, expected: Int) {
        assertEquals(expected, subject.lengthOfLongestSubstring(s))
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // s, expected
            return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("aab", 2),
                Arguments.of("dvdf", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("", 0),
                Arguments.of("abcdefgh", 8)
            )
        }
    }
}