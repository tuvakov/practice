package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DecodeStringTest {

    private val subject = DecodeString()

    @ParameterizedTest
    @MethodSource("arguments")
    fun decodeString(s: String, output: String) {
        val result = subject.decodeString(s)
        assertEquals(output, result)
    }

    @Test
    fun biggie() {
        val s = "100[leetcode]"
        val output = "leetcode".repeat(100)
        val result = subject.decodeString(s)
        assertEquals(output, result)

    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // s, output
            return Stream.of(
                Arguments.of("3[a]2[bc]", "aaabcbc"),
                Arguments.of("3[a2[c]]", "accaccacc"),
                Arguments.of("2[abc]3[cd]ef", "abcabccdcdcdef"),
                Arguments.of(
                    "3[z]2[2[y]pq4[2[jk]e1[f]]]ef",
                    "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
                )
            )
        }
    }
}