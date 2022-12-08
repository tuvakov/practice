package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FibonacciTest {

    private val subject = Fibonacci()

    @ParameterizedTest
    @MethodSource("arguments")
    fun fib(n: Int, output: Int) {
        val result = subject.fib(n)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(6, 8),
                Arguments.of(4, 3),
                Arguments.of(8, 21)
            )
        }
    }
}