package leetcode.dp

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CoinChangeIITest {

    private val subject = CoinChangeII()

    @ParameterizedTest
    @MethodSource("arguments")
    fun change(amount: Int, coins: IntArray, expected: Int) {
        val result = subject.change(amount, coins)
        assertEquals(expected, result)
    }

    @Test
    fun change_largeAmount() {
        val result = subject.change(
            amount = 151, coins = intArrayOf(1, 2, 5, 8, 10, 12)
        )
        val expected = 121944
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    5, intArrayOf(1, 2, 5), 4
                ),
                Arguments.of(
                    100, intArrayOf(1), 1
                ),
                Arguments.of(
                    100, intArrayOf(100), 1
                ),
                Arguments.of(
                    3, intArrayOf(2), 0
                ),
                Arguments.of(
                    4, intArrayOf(2, 1), 3
                ),
                Arguments.of(
                    0, intArrayOf(1, 2, 5), 1
                )
            )
        }
    }
}