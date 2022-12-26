package leetcode.bitman

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ReverseBitsTest {

    private val subject = ReverseBits()

    @ParameterizedTest
    @MethodSource("arguments")
    fun reverseBits(n: Int, output: Int) {
        val result = subject.reverseBits(n)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "00000010100101000001111010011100".toInt(2),
                    "00111001011110000010100101000000".toInt(2)
                )
            )
        }
    }
}