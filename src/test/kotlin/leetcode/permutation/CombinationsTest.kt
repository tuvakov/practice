package leetcode.permutation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CombinationsTest {

    private val subject = Combinations()

    @ParameterizedTest
    @MethodSource("arguments")
    fun combine(n: Int, k: Int, output: List<List<Int>>) {
        val result = subject.combine(n, k)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    5, 3,
                    listOf(
                        listOf(1, 2, 3),
                        listOf(1, 2, 4),
                        listOf(1, 2, 5),
                        listOf(1, 3, 4),
                        listOf(1, 3, 5),
                        listOf(1, 4, 5),
                        listOf(2, 3, 4),
                        listOf(2, 3, 5),
                        listOf(2, 4, 5),
                        listOf(3, 4, 5)
                    )
                ),
                Arguments.of(
                    5, 1,
                    listOf(
                        listOf(1),
                        listOf(2),
                        listOf(3),
                        listOf(4),
                        listOf(5)
                    )
                ),
                Arguments.of(
                    4, 2,
                    listOf(
                        listOf(1, 2),
                        listOf(1, 3),
                        listOf(1, 4),
                        listOf(2, 3),
                        listOf(2, 4),
                        listOf(3, 4)
                    )
                ),
                Arguments.of(
                    4, 4,
                    listOf(listOf(1, 2, 3, 4))
                ),
                Arguments.of(
                    1, 1,
                    listOf(listOf(1))
                )
            )
        }
    }
}