package leetcode.string

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RomanToIntegerTest {

    private val subject = RomanToInteger()

    @ParameterizedTest
    @MethodSource("arguments")
    fun romanToInt(roman: String, output: Int) {
        val result = subject.romanToInt(roman)
        assertEquals(output, result)
    }

    companion object {

        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("VI", 6),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994)
            )
        }
    }
}