package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class GroupAnagramsTest {

    private val subject = GroupAnagrams()

    @ParameterizedTest
    @MethodSource("arguments")
    fun groupAnagrams(strings: Array<String>, output: List<List<String>>) {
        val result = subject.groupAnagrams(strings)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf("eat", "tea", "tan", "ate", "nat", "bat"),
                    listOf(
                        listOf("eat", "tea", "ate"),
                        listOf("tan", "nat"),
                        listOf("bat")
                    )
                ),
                Arguments.of(
                    arrayOf(""),
                    listOf(listOf(""))
                ),
                Arguments.of(
                    arrayOf("a"),
                    listOf(listOf("a"))
                )
            )
        }
    }
}