package leetcode.math

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigInteger
import java.util.stream.Stream

class MultiplyStringsTest {

    private val subject = MultiplyStrings()

    @ParameterizedTest
    @MethodSource("arguments")
    fun multiply(num1: String, num2: String, expected: String) {
        val result = subject.multiply(num1, num2)
        assertEquals(expected, result)
    }

    @Test
    fun multiply_largeInput() {
        val num1 = "723894729347891720398479001923748191237849"
        val num2 = "7238947293478917203984701923748191237849".reversed()
        val expected = BigInteger(num1).multiply(BigInteger(num2)).toString()
        val result = subject.multiply(num1, num2)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "123", "456", "56088"
                ),
                Arguments.of(
                    "2", "3", "6"
                ),
                Arguments.of(
                    "18", "2", "36"
                ),
                Arguments.of(
                    "8", "2", "16"
                ),
                Arguments.of(
                    "0", "2", "0"
                ),
                Arguments.of(
                    "11231231238", "0", "0"
                ),
                Arguments.of(
                    "1234478", "987", "1218429786"
                ),
                Arguments.of(
                    "987", "1234478", "1218429786"
                )
            )
        }
    }
}