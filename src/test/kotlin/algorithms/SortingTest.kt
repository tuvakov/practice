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

    @ParameterizedTest
    @MethodSource("arguments")
    fun bubbleSort(arr: IntArray) {
        Sorting.bubbleSort(arr)
        assertTrue(arr.isSorted())
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun insertionSort(arr: IntArray) {
        Sorting.insertionSort(arr)
        assertTrue(arr.isSorted())
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun mergeSort(arr: IntArray) {
        Sorting.mergeSort(arr)
        assertTrue(arr.isSorted())
    }

    @ParameterizedTest
    @MethodSource("argumentsLarge")
    fun mergeSort_largeInput(arr: IntArray) {
        Sorting.mergeSort(arr)
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

        @JvmStatic
        fun argumentsLarge(): Stream<Arguments> {
            val arr = randomIntArray(size = 10_000_000)
            return Stream.of(
                Arguments.of(arr),
                Arguments.of(arr.apply { sort() }),
                Arguments.of(arr.apply { sortDescending() })
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