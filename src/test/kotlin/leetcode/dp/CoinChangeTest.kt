package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

class CoinChangeTest {

    private val subject = CoinChange()

    @ParameterizedTest
    @MethodSource("largeInput")
    fun coinChangeTopDown_largeInput(
        coins: IntArray,
        amount: Int,
        expected: Int
    ) {
        val result = subject.coinChangeTopDown(coins, amount)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("largeInput")
    fun coinChangeSet_largeInput(coins: IntArray, amount: Int, expected: Int) {
        val result = subject.coinChangeSet(coins, amount)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("largeInput")
    fun coinChangeBottomUp_largeInput(
        coins: IntArray,
        amount: Int,
        expected: Int
    ) {
        val result = subject.coinChangeBottomUp(coins, amount)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun coinChangeTopDown(coins: IntArray, amount: Int, expected: Int) {
        val result = subject.coinChangeTopDown(coins, amount)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun coinChangeBottomUp(coins: IntArray, amount: Int, expected: Int) {
        val result = subject.coinChangeBottomUp(coins, amount)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun coinChangeSet(coins: IntArray, amount: Int, expected: Int) {
        val result = subject.coinChangeSet(coins, amount)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(1, 2, 5), 11, 3
                ),
                Arguments.of(
                    intArrayOf(1, 2, 7), 11, 3
                ),
                Arguments.of(
                    intArrayOf(1, 2, 7), 13, 4
                ),
                Arguments.of(
                    intArrayOf(1, 2, 5), 5, 1
                ),
                Arguments.of(
                    intArrayOf(4, 5), 18, 4
                ),
                Arguments.of(
                    intArrayOf(1), 100, 100
                ),
                Arguments.of(
                    intArrayOf(100), 100, 1
                ),
                Arguments.of(
                    intArrayOf(2), 3, -1
                ),
                Arguments.of(
                    intArrayOf(2, 1), 4, 2
                ),
                Arguments.of(
                    intArrayOf(4, 2, 8, 7, 5), 3, -1
                ),
                Arguments.of(
                    intArrayOf(1, 2, 5), 0, 0
                ),
                Arguments.of(
                    intArrayOf(4, 2, 3), 5, 2
                )
            )
        }

        @JvmStatic
        fun largeInput(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24),
                    9999,
                    -1
                )
            )
        }
    }
}