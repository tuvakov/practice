package leetcode.contest.weekly

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MaximumNestingDepthOfParenthesesTest {

    val subject = MaximumNestingDepthOfParentheses()

    @ParameterizedTest
    @MethodSource("arguments")
    fun maxDepth(s: String, expected: Int) {
        assertEquals(expected, subject.maxDepth(s))
    }

    companion object {

        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("(1+(2*3)+((8)/4))+1", 3),
                Arguments.of("(1)+((2))+(((3)))", 3),
                Arguments.of("1+(2*3)/(2-1)", 1),
                Arguments.of("1", 0),
                Arguments.of("", 0)
            )
        }
    }
}