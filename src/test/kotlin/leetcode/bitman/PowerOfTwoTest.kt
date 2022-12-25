package leetcode.bitman

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PowerOfTwoTest {

    private val subject = PowerOfTwo()

    @ParameterizedTest
    @MethodSource("arguments")
    fun isPowerOfTwoBitwise(n: Int, output: Boolean) {
        val result = subject.isPowerOfTwoBitwise(n)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun isPowerOfTwo(n: Int, output: Boolean) {
        val result = subject.isPowerOfTwo(n)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, true),
                Arguments.of(16, true),
                Arguments.of(0, false),
                Arguments.of(3, false),
                Arguments.of(-4, false),
                Arguments.of(-1, false),
                Arguments.of(-2147483648, false)
            )
        }
    }
}