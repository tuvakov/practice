package leetcode.math

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class HappyNumberTest {

    private val subject = HappyNumber()

    @ParameterizedTest
    @MethodSource("arguments")
    fun isHappy(n: Int, expected: Boolean) {
        val result = subject.isHappy(n)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun isHappyFloyd(n: Int, expected: Boolean) {
        val result = subject.isHappyFloyd(n)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(19, true),
                Arguments.of(2, false),
                Arguments.of(1, true),
                Arguments.of(100, true),
                Arguments.of(7, true),
                Arguments.of(8, false),
                Arguments.of(21, false)
            )
        }
    }
}