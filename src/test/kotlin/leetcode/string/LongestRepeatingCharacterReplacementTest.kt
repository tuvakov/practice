package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LongestRepeatingCharacterReplacementTest {

    private val subject = LongestRepeatingCharacterReplacement()

    @ParameterizedTest
    @MethodSource("arguments")
    fun characterReplacement(s: String, k: Int, output: Int) {
        val result = subject.characterReplacement(s, k)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // s, k, output
            return Stream.of(
                Arguments.of("ABAB", 2, 4),
                Arguments.of("AABABBA", 1, 4),
                Arguments.of("AABABBA", 0, 2),
                Arguments.of("CCCDCCC", 2, 7),
                Arguments.of("C", 1, 1),
                Arguments.of("C", 2, 1),
                Arguments.of("AC", 1, 2),
                Arguments.of("AC", 0, 1),
                Arguments.of("ABBB", 2, 4)
            )
        }
    }
}