package leetcode.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FizzBuzzTest {

    private val subject = FizzBuzz()

    @ParameterizedTest
    @MethodSource("arguments")
    fun fizzBuzz(n: Int, output: List<String>) {
        val result = subject.fizzBuzz(n)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of<Arguments>(
                Arguments.of(
                    1,
                    listOf("1")
                ),
                Arguments.of(
                    2,
                    listOf("1", "2")
                ),
                Arguments.of(
                    3,
                    listOf("1", "2", "Fizz")
                ),
                Arguments.of(
                    5,
                    listOf("1", "2", "Fizz", "4", "Buzz")
                ),
                Arguments.of(
                    15,
                    listOf(
                        "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz",
                        "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"
                    )
                )
            )
        }
    }
}