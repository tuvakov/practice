package leetcode.math

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class IntegerToRomanTest {

    private val subject = IntegerToRoman()

    @ParameterizedTest
    @MethodSource("arguments")
    fun intToRoman(int: Int, roman: String) {
        val result = subject.intToRoman(int)
        assertEquals(roman, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun intToRoman2(int: Int, roman: String) {
        val result = subject.intToRoman2(int)
        assertEquals(roman, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(8, "VIII"),
                Arguments.of(10, "X"),
                Arguments.of(101, "CI"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV"),
                Arguments.of(2002, "MMII"),
                Arguments.of(30, "XXX"),
                Arguments.of(830, "DCCCXXX"),
                Arguments.of(100, "C")
            )
        }
    }
}