package leetcode.heap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TopKFrequentWordsTest {

    private val subject = TopKFrequentWords()

    @ParameterizedTest
    @MethodSource("arguments")
    fun topKFrequent(words: Array<String>, k: Int, output: List<String>) {
        val result = subject.topKFrequent(words, k)
        assertEquals(output, result)
    }

    companion object {

        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf("i", "love", "leetcode", "i", "love", "coding"),
                    2,
                    listOf("i", "love")
                ),
                Arguments.of(
                    arrayOf(
                        "the", "day", "is", "sunny", "the", "the",
                        "the", "sunny", "is", "is"
                    ),
                    4,
                    listOf("the", "is", "sunny", "day")
                )
            )
        }
    }
}