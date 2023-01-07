package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PhonePadLetterCombinationTest {

    private val subject = PhonePadLetterCombination()

    @ParameterizedTest
    @MethodSource("arguments")
    fun letterCombinations(digits: String, output: List<String>) {
        val result = subject.letterCombinations(digits)
        assertEquals(result, output)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "2",
                    listOf("a", "b", "c")
                ),
                Arguments.of(
                    "23",
                    listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
                ),
                Arguments.of(
                    "",
                    emptyList<String>()
                )
            )
        }
    }
}