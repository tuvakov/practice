package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WordBreakTest {

    private val subject = WordBreak()

    @ParameterizedTest
    @MethodSource("arguments")
    fun wordBreak(s: String, wordDict: List<String>, output: Boolean) {
        val result = subject.wordBreak(s, wordDict)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun wordBreakIterative(s: String, wordDict: List<String>, output: Boolean) {
        val result = subject.wordBreakIterative(s, wordDict)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "leetcode", listOf("leet", "code"), true
                ),
                Arguments.of(
                    "applepenapple", listOf("apple", "pen"), true
                ),
                Arguments.of(
                    "catsandog",
                    listOf("cats", "dog", "sand", "and", "cat"),
                    false
                ),
                Arguments.of(
                    "aaa",
                    listOf("a", "aaaa"),
                    true
                ),
                Arguments.of(
                    "goalspecial",
                    listOf("go", "goal", "goals", "special"),
                    true
                ),
                Arguments.of(
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                    listOf(
                        "a",
                        "aa",
                        "aaa",
                        "aaaa",
                        "aaaaa",
                        "aaaaaa",
                        "aaaaaaa",
                        "aaaaaaaa",
                        "aaaaaaaaa",
                        "aaaaaaaaaa"
                    ),
                    false
                )
            )
        }
    }
}