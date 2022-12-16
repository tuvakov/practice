package leetcode.heap


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LastStoneWeightTest {

    private val subject = LastStoneWeight()

    @ParameterizedTest
    @MethodSource("arguments")
    fun lastStoneWeight(stones: IntArray, output: Int) {
        val result = subject.lastStoneWeight(stones)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(2, 7, 4, 1, 8, 1), 1),
                Arguments.of(intArrayOf(1), 1)
            )
        }
    }
}