package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LetterCasePermutationTest {

    private val subject = LetterCasePermutation()

    @ParameterizedTest
    @MethodSource("arguments")
    fun letterCasePermutation(s: String, output: List<String>) {
        val result = subject.letterCasePermutation(s)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // s, output
            return Stream.of(
                Arguments.of(
                    "a1b2",
                    listOf("a1b2", "a1B2", "A1b2", "A1B2")
                ),
                Arguments.of(
                    "3z4",
                    listOf("3z4", "3Z4")
                ),
                Arguments.of(
                    "c",
                    listOf("c", "C")
                ),
                Arguments.of(
                    "C",
                    listOf("c", "C")
                )
            )
        }
    }
}