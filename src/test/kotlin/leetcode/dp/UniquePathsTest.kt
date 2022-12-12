package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class UniquePathsTest {

    private val subject = UniquePaths()

    @ParameterizedTest
    @MethodSource("arguments")
    fun uniquePaths(m: Int, n: Int, output: Int) {
        val result = subject.uniquePaths(m, n)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                // m, n, output
                Arguments.of(3, 7, 28),
                Arguments.of(3, 2, 3),
                Arguments.of(1, 1, 1)
            )
        }
    }
}