package leetcode.permutation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SubsetsTest {

    private val subject = Subsets()

    @ParameterizedTest
    @MethodSource("arguments")
    fun subsets(nums: IntArray, output: List<List<Int>>) {
        val result = subject.subsets(nums)
        assertEquals(output, result)
    }

    companion object {
        @JvmStatic
        private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    intArrayOf(1),
                    listOf(emptyList(), listOf(1))
                ),
                Arguments.of(
                    intArrayOf(1, 2),
                    listOf(emptyList(), listOf(1), listOf(1, 2), listOf(2))
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3),
                    listOf(
                        emptyList(),
                        listOf(1),
                        listOf(1, 2),
                        listOf(1, 2, 3),
                        listOf(1, 3),
                        listOf(2),
                        listOf(2, 3),
                        listOf(3)
                    )
                )
            )
        }
    }
}