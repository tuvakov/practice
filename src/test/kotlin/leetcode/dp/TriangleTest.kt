package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TriangleTest {

    private val subject = Triangle()

    @ParameterizedTest
    @MethodSource("arguments")
    fun minimumTotal(triangle: List<List<Int>>, output: Int) {
        val result = subject.minimumTotal(triangle)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        listOf(2),
                        listOf(3, 4),
                        listOf(6, 5, 7),
                        listOf(4, 1, 8, 3)
                    ), 11
                ),
                Arguments.of(listOf(listOf(-10)), -10),
                Arguments.of(listOf(listOf(10), listOf(10, 0)), 10)
            )
        }
    }
}