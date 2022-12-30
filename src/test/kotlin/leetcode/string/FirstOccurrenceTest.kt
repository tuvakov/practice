package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FirstOccurrenceTest {

    private val subject = FirstOccurrence()

    @ParameterizedTest
    @MethodSource("arguments")
    fun findFirstOccurrence(
        haystack: String,
        needle: String,
        output: Int
    ) {
        val result = subject.findFirstOccurrence(haystack, needle)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("sadbutsad", "sadbutsad", 0),
                Arguments.of("leetcode", "leeto", -1),
                Arguments.of("o", "o", 0),
                Arguments.of("ccccabc", "abc", 4),
                Arguments.of("aaaaabc", "abc", 4),
                Arguments.of("mississippi", "issip", 4)
            )
        }
    }
}