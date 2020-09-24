package algorithms

import algorithms.BinarySearch.findFirstOccurrence
import algorithms.BinarySearch.iterativeBinarySearch
import algorithms.BinarySearch.recursiveBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.random.Random

internal class BinarySearchTest {

    @Test
    fun binarySearch_singleElementArr_finds() {
        val arr = intArrayOf(78)
        val x = 78
        val iterativeResult = iterativeBinarySearch(arr, x)
        val recursiveResult = recursiveBinarySearch(arr, x)
        val expectedResult = arr.binarySearch(x)
        assertEquals(expectedResult, iterativeResult)
        assertEquals(expectedResult, recursiveResult)
    }

    @Test
    fun binarySearch_singleElementArr_doesNotFind() {
        val arr = intArrayOf(78)
        val x = 75
        val iterativeResult = iterativeBinarySearch(arr, x)
        val recursiveResult = recursiveBinarySearch(arr, x)
        val expectedResult = arr.binarySearch(x)
        assertTrue(iterativeResult < 0)
        assertTrue(recursiveResult < 0)
        assertTrue(expectedResult < 0)
    }

    @Test
    fun binarySearch_multipleElements_finds() {
        val arr = intArrayOf(1, 3, 6, 46, 66, 78)
        val x = 66
        val iterativeResult = iterativeBinarySearch(arr, x)
        val recursiveResult = recursiveBinarySearch(arr, x)
        val expectedResult = arr.binarySearch(x)
        assertEquals(expectedResult, iterativeResult)
        assertEquals(expectedResult, recursiveResult)
    }

    @Test
    fun binarySearch_multipleElements_doesNotFind() {
        val arr = intArrayOf(-4, -1, 4, 8, 18)
        val x = 0
        val iterativeResult = iterativeBinarySearch(arr, x)
        val recursiveResult = recursiveBinarySearch(arr, x)
        val expectedResult = arr.binarySearch(x)
        assertTrue(iterativeResult < 0)
        assertTrue(recursiveResult < 0)
        assertTrue(expectedResult < 0)
    }

    @Test
    fun binarySearch_findFirstElement() {
        val arr = intArrayOf(1, 3, 6, 46, 66, 78)
        val x = 1
        val iterativeResult = iterativeBinarySearch(arr, x)
        val recursiveResult = recursiveBinarySearch(arr, x)
        val expectedResult = arr.binarySearch(x)
        assertEquals(expectedResult, iterativeResult)
        assertEquals(expectedResult, recursiveResult)
    }

    @Test
    fun binarySearch_findMiddleElement() {
        val arr = intArrayOf(1, 3, 6, 46, 66, 78)
        val x = 6
        val iterativeResult = iterativeBinarySearch(arr, x)
        val recursiveResult = recursiveBinarySearch(arr, x)
        val expectedResult = arr.binarySearch(x)
        assertEquals(expectedResult, iterativeResult)
        assertEquals(expectedResult, recursiveResult)
    }

    @Test
    fun binarySearch_findLastElement() {
        val arr = intArrayOf(1, 3, 6, 46, 66, 78)
        val x = 78
        val iterativeResult = iterativeBinarySearch(arr, x)
        val recursiveResult = recursiveBinarySearch(arr, x)
        val expectedResult = arr.binarySearch(x)
        assertEquals(expectedResult, iterativeResult)
        assertEquals(expectedResult, recursiveResult)
    }

    @Test
    fun binarySearch_randomArrAndRandomElement() {
        val list = mutableListOf<Int>()
        val from = -20
        val until = 20

        for (i in 0..15) {
            list.add(Random.nextInt(from, until))
        }

        val arr = list.sorted().toIntArray()
        val x = Random.nextInt(from = from, until = until)
        val expectedResult = arr.binarySearch(x)
        val iterativeResult = iterativeBinarySearch(arr, x)
        val recursiveResult = recursiveBinarySearch(arr, x)
        if (expectedResult > 0) {
            assertEquals(expectedResult, iterativeResult)
            assertEquals(expectedResult, recursiveResult)
        } else {
            assertEquals(-1, iterativeResult)
            assertEquals(-1, recursiveResult)
        }
    }

    @Test
    fun binarySearch_randomArrAndRandomElement_veryLargeArr() {
        val list = mutableListOf<Int>()
        val from = 0
        val until = 100_000

        for (i in 1..1_000_000) {
            list.add(Random.nextInt(from, until))
        }

        val arr = list.sorted().toIntArray()
        val x = Random.nextInt(from = from, until = until)
        val expectedResult = arr.binarySearch(x)
        val iterativeResult = iterativeBinarySearch(arr, x)
        val recursiveResult = recursiveBinarySearch(arr, x)
        if (expectedResult > 0) {
            assertEquals(expectedResult, iterativeResult)
            assertEquals(expectedResult, recursiveResult)
        } else {
            assertEquals(-1, iterativeResult)
            assertEquals(-1, recursiveResult)
        }
    }

    @Test
    fun findFirstOccurrence_allElementsAreTheSame() {
        val arr = intArrayOf(0, 0, 0, 0, 0, 0)
        val x = 0
        val expectedResult = 0
        val actualResult = findFirstOccurrence(arr, x)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun findFirstOccurrence_positionIsZero() {
        val arr = intArrayOf(0, 1, 1, 1, 1, 1)
        val x = 0
        val expectedResult = 0
        val actualResult = findFirstOccurrence(arr, x)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun findFirstOccurrence_positionLast() {
        val arr = intArrayOf(0, 0, 0, 1)
        val x = 1
        val expectedResult = 3
        val actualResult = findFirstOccurrence(arr, x)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun findFirstOccurrence_positionMiddle() {
        val arr = intArrayOf(0, 1, 2, 4, 5, 6, 7)
        val x = 4
        val expectedResult = 3
        val actualResult = findFirstOccurrence(arr, x)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun findFirstOccurrence_accumulatedInTheMiddle() {
        val arr = intArrayOf(0, 0, 0, 0, 4, 4, 4, 4, 5, 5, 5, 5)
        val x = 4
        val expectedResult = 4
        val actualResult = findFirstOccurrence(arr, x)
        assertEquals(expectedResult, actualResult)
    }

    @ParameterizedTest
    @MethodSource("countOccurrencesArguments")
    fun countOccurrences(arr: IntArray, x: Int, expected: Int) {
        val actual = BinarySearch.countOccurrences(arr, x)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("countSortedArrayRotationsArguments")
    fun countSortedArrayRotations(arr: IntArray, expected: Int) {
        val actual = BinarySearch.countSortedArrayRotations(arr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("findElementInCircularlySortedArrayArguments")
    fun findElementInCircularlySortedArray(
        arr: IntArray,
        x: Int,
        expected: Int
    ) {
        val actual = BinarySearch.findElementInCircularlySortedArray(arr, x)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("findMissingElementPositionArguments")
    fun findMissingElementPosition(arr: IntArray, x: Int) {
        val actual = BinarySearch.findMissingElementPosition(arr, x)
        assertEquals(arr.binarySearch(x), actual)
    }


    companion object {
        @JvmStatic
        private fun countOccurrencesArguments(): Stream<Arguments> {
            // arr, x, expected
            return Stream.of(
                Arguments.of(intArrayOf(), 5, 0),
                Arguments.of(intArrayOf(1, 2, 3, 4), 5, 0),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 1, 1),
                Arguments.of(intArrayOf(1, 2, 3, 5, 6), 6, 1),
                Arguments.of(intArrayOf(1, 2, 2, 2, 7), 2, 3),
                Arguments.of(intArrayOf(1, 1, 1, 1, 2, 2, 2), 2, 3),
                Arguments.of(intArrayOf(1, 1, 1, 1, 2, 2, 2), 1, 4)
            )
        }

        @JvmStatic
        private fun countSortedArrayRotationsArguments(): Stream<Arguments> {
            // arr, expected
            return Stream.of(
                Arguments.of(intArrayOf(), 0),
                Arguments.of(intArrayOf(1, 2, 3, 4), 0),
                Arguments.of(intArrayOf(5, 1, 2, 3, 4), 1),
                Arguments.of(intArrayOf(7, 8, 9, 1, 2), 3),
                Arguments.of(intArrayOf(7, 8, 1, 2, 3), 2),
                Arguments.of(intArrayOf(11, 12, 15, 18, 2, 5, 6, 8), 4),
                Arguments.of(
                    intArrayOf(15, 22, 23, 28, 31, 38, 5, 6, 8, 10, 12),
                    6
                )
            )
        }

        @JvmStatic
        private fun findElementInCircularlySortedArrayArguments()
                : Stream<Arguments> {

            // arr, x, expected
            return Stream.of(
                Arguments.of(intArrayOf(), 5, -1),
                Arguments.of(intArrayOf(1, 2, 3, 4), 5, -1),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 1, 0),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 5, 4),
                Arguments.of(intArrayOf(3, 4, 5, 1, 2), 5, 2),
                Arguments.of(intArrayOf(3, 4, 5, 1, 2), 2, 4),
                Arguments.of(intArrayOf(3, 4, 5, 1, 2), 3, 0),
                Arguments.of(intArrayOf(3, 4, 5, 1, 2), 7, -1),
                Arguments.of(intArrayOf(12, 14, 18, 21, 3, 6, 8, 9), 7, -1),
                Arguments.of(intArrayOf(12, 14, 18, 21, 3, 6, 8, 9), 6, 5)
            )
        }

        @JvmStatic
        private fun findMissingElementPositionArguments(): Stream<Arguments> {
            // arr, x
            return Stream.of(
                Arguments.of(intArrayOf(), 4),
                Arguments.of(intArrayOf(1, 2, 3, 4), 0),
                Arguments.of(intArrayOf(1, 2, 3, 4), 5),
                Arguments.of(intArrayOf(1, 2, 7, 8, 9), 3),
                Arguments.of(intArrayOf(7, 9, 11, 21, 37), 8),
                Arguments.of(
                    intArrayOf(5, 6, 8, 10, 12, 15, 22, 23, 28, 31, 38),
                    34
                )
            )
        }
    }
}