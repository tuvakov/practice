package leetcode.dfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WordSearchTest {

    private val subject = WordSearch()

    @ParameterizedTest
    @MethodSource("arguments")
    fun exist(board: Array<CharArray>, word: String, output: Boolean) {
        val result = subject.exist(board, word)
        assertEquals(output, result)
    }

    companion object {

        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E')
                    ),
                    "ABCCED",
                    true
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E')
                    ),
                    "SEE",
                    true
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E')
                    ),
                    "ABCB",
                    false
                ),
                Arguments.of(
                    arrayOf(
                        charArrayOf('A')
                    ),
                    "A",
                    true
                )
            )
        }
    }
}