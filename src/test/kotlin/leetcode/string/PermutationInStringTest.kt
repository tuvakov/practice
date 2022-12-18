package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PermutationInStringTest {

    private val subject = PermutationInString()

    @ParameterizedTest
    @MethodSource("arguments")
    fun checkInclusion(s: String, t: String, output: Boolean) {
        val result = subject.checkInclusion(s, t)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("ab", "eidbaooo", true),
                Arguments.of("ab", "eidboaoo", false),
                Arguments.of("abc", "abc", true),
                Arguments.of("abc", "cba", true),
                Arguments.of("ababab", "bcbcbc", false)
            )
        }
    }
}