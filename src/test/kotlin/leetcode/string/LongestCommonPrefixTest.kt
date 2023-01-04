package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LongestCommonPrefixTest {

    private val subject = LongestCommonPrefix()

    @ParameterizedTest
    @MethodSource("arguments")
    fun longestCommonPrefix(strings: Array<String>, output: String) {
        val result = subject.longestCommonPrefix(strings)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun longestCommonPrefixSort(strings: Array<String>, output: String) {
        val result = subject.longestCommonPrefixSort(strings)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf("flower", "flow", "flight"), "fl"),
                Arguments.of(arrayOf("dog", "racecar", "car"), ""),
                Arguments.of(arrayOf("aaaaaa", "aaa"), "aaa")
            )
        }
    }
}