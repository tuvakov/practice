package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BullsAndCowsTest {

    private val subject = BullsAndCows()

    @ParameterizedTest
    @MethodSource("arguments")
    fun getHint(secret: String, guess: String, output: String) {
        val result = subject.getHint(secret, guess)
        assertEquals(output, result)
    }

    companion object {

        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // secret, guess, output
            return Stream.of(
                Arguments.of("1807", "7810", "1A3B"),
                Arguments.of("1123", "0111", "1A1B"),
                Arguments.of("11234", "01111", "1A1B"),
                Arguments.of("112331", "011111", "2A1B"),
                Arguments.of("55555", "55555", "5A0B"),
                Arguments.of("111222", "222111", "0A6B"),
                Arguments.of("1111", "2222", "0A0B"),
                Arguments.of("11", "10", "1A0B"),
                Arguments.of("1122", "0001", "0A1B")
            )
        }
    }
}