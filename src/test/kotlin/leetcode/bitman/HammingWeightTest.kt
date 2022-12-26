package leetcode.bitman

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class HammingWeightTest {

    private val subject = HammingWeight()

    @ParameterizedTest
    @MethodSource("arguments")
    fun hammingWeight(num: Int) {
        val result = subject.hammingWeight(num)
        assertEquals(Integer.bitCount(num), result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0),
                Arguments.of(2),
                Arguments.of(20),
                Arguments.of(23),
                Arguments.of(98),
                Arguments.of(255),
                Arguments.of(-8282),
                Arguments.of(-47),
                Arguments.of(-1)
            )
        }
    }
}