package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LongestPalindromeByConcatTest {

    private val subject = LongestPalindromeByConcat()

    @ParameterizedTest
    @MethodSource("arguments")
    fun longestPalindrome(words: Array<String>, expected: Int) {
        val result = subject.longestPalindrome(words)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf("lc", "cl", "gg"), 6
                ),
                Arguments.of(
                    arrayOf(
                        "lc", "lc", "lc", "lc", "lc", "cl", "cl", "cl", "gg"
                    ), 14
                ),
                Arguments.of(
                    arrayOf("ab", "ty", "yt", "lc", "cl", "ab"), 8
                ),
                Arguments.of(
                    arrayOf("cc", "ll", "xx"), 2
                ),
                Arguments.of(
                    arrayOf(
                        "dd",
                        "aa",
                        "bb",
                        "dd",
                        "aa",
                        "dd",
                        "bb",
                        "dd",
                        "aa",
                        "cc",
                        "bb",
                        "cc",
                        "dd",
                        "cc"
                    ), 22
                ),
                Arguments.of(
                    arrayOf(
                        "dd",
                        "aa",
                        "dd",
                        "bb",
                        "dd",
                        "aa",
                        "bb",
                        "cc",
                        "dd",
                        "cc"
                    ), 20
                )
            )
        }
    }
}