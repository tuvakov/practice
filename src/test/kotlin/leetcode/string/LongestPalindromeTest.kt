package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LongestPalindromeTest {

    private val subject = LongestPalindrome()

    @ParameterizedTest
    @MethodSource("arguments")
    fun longestPalindrome(s: String, output: Int) {
        assertEquals(subject.longestPalindrome(s), output)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("a", 1),
                Arguments.of("aa", 2),
                Arguments.of("bbb", 3),
                Arguments.of("abccccdd", 7),
                Arguments.of("aaccdd", 6)
            )
        }
    }
}