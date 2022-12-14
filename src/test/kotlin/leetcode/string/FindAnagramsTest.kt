package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FindAnagramsTest {

    private val subject = FindAnagrams()

    @ParameterizedTest
    @MethodSource("arguments")
    fun findAnagrams(s: String, p: String, output: List<Int>) {
        val result = subject.findAnagrams(s, p)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // s, p, output
            return Stream.of(
                Arguments.of("cbaebabacd", "abc", listOf(0, 6)),
                Arguments.of("abab", "ab", listOf(0, 1, 2)),
                Arguments.of("aaaa", "a", listOf(0, 1, 2, 3)),
                Arguments.of("aaaa", "c", emptyList<Int>()),
                Arguments.of("aaaa", "aaaaa", emptyList<Int>()),
                Arguments.of("aaaa", "aaaa", listOf(0))
            )
        }
    }
}