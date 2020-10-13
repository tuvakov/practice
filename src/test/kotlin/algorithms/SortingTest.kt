package algorithms

import algorithms.Sorting.isSorted
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

internal class SortingTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun selectionSort(arr: IntArray) {
        Sorting.selectionSort(arr)
        assertTrue(arr.isSorted())
    }

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 2, 3, 4, 5)),
                Arguments.of(intArrayOf(5, 4, 3, 2, 1)),
                Arguments.of(intArrayOf(1, 4, 5, 2, 3)),
                Arguments.of(randomIntArray(size = 100).apply { sort() }),
                Arguments.of(randomIntArray(size = 150)),
                Arguments.of(randomIntArray(size = 1000)),
                Arguments.of(randomIntArray(size = 10_000))
            )
        }

        fun randomIntArray(size: Int = 100, limit: Int = 100_000): IntArray {
            return IntArray(size).apply {
                val random = Random()
                for (i in 0 until size) {
                    this[i] = random.nextInt(limit)
                }
            }
        }
    }

}