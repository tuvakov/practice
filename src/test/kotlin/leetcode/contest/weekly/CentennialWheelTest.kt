package leetcode.contest.weekly

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CentennialWheelTest {

    val subject = CentennialWheel()

    @ParameterizedTest
    @MethodSource("arguments")
    fun minOperationsMaxProfit(
        arr: IntArray,
        boardingCost: Int,
        runningCost: Int,
        expected: Int
    ) {
        assertEquals(
            expected,
            subject.minOperationsMaxProfit(arr, boardingCost, runningCost)
        )
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            // arr, boardingCost, runningCost, expected
            return Stream.of(
                Arguments.of(intArrayOf(8, 3), 5, 6, 3),
                Arguments.of(intArrayOf(10, 9, 6), 6, 4, 7),
                Arguments.of(intArrayOf(3, 4, 0, 5, 1), 1, 92, -1),
                Arguments.of(intArrayOf(10, 10, 6, 4, 7), 3, 8, 9),
                Arguments.of(intArrayOf(10, 10, 1, 0, 0), 4, 4, 5),
                Arguments.of(intArrayOf(32,43,39,29,10,15,
                    36,44,34,9,2,16,
                    49,47,48,40,39,35,22,48,41,46,17,47,25,
                    17,0,45,39,19,4,
                    9,3,16,35,14,23,23,15,11,17,31,31,47,50,5,
                    46,29,15,14,37,
                    28,33,6,39,45,49,44,11,38,28,25,20,36,27,15,3,1,
                    37,49,5,
                    34,26,45,40,47,43,46,35,1,30,28,22
                ),                11, 33, 586),
                Arguments.of(intArrayOf(0,43,37,9,23,35,18,7,45,3,
                    8,24,1,6,
                    37,2,38,15,1,14,39,27,4,25,27,33,43,8,
                    44,30,38,40,20,
                    5,17,27,43,11,6,2,30,49,30,25,32,3,18,
                    23,45,43,30,14,41,
                    17,42,42,44,38,18,26,32,48,37,5,37,
                    21,2,9,48,48,40,45,
                    25,30,49,41,4,48,40,29,23,17,7,5,44,
                    23,43,9,35,26,44,3,
                    26,16,31,11,9,4,28,49,43,39,9,39,37,7,6,7,16,1,30,2,4,
                    43,23,16,39,5,30,23,39,29,31,26,35,15,5,
                    11,45,44,45,43,
                    4,24,40,7,36,10,10,18,6,20,13,11,20,3,32,49,34,41,13,
                    11,3,13,0,13,44,48,43,23,12,23,2), 43, 54, 993)
            )
        }
    }
}