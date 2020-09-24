package algorithms

object BinarySearch {

    /**
     * Traditional binary search.
     */
    fun iterativeBinarySearch(arr: IntArray, x: Int): Int {
        if (arr.isEmpty())
            return -1
        var start = 0
        var end = arr.lastIndex
        while (start <= end) {
            val middle: Int = start + (end - start) / 2
            when {
                x > arr[middle] -> start = middle + 1
                x < arr[middle] -> end = middle - 1
                else -> return middle
            }
        }
        return -1
    }

    /**
     * Traditional binary search implemented in recursive way.
     */
    fun recursiveBinarySearch(arr: IntArray, x: Int): Int {
        if (arr.isEmpty()) return -1
        return recursiveBinarySearch(arr, x, start = 0, end = arr.lastIndex)
    }

    /**
     * Binary search implementation that returns the index of element in it
     * exists, otherwise the inverted insertion point `(-insertion point - 1)`
     * like Java implementation does.
     */
    fun findMissingElementPosition(arr: IntArray, x: Int): Int {
        if (arr.isEmpty()) return -1
        var start = 0
        var end = arr.lastIndex
        while (start <= end) {
            val middle: Int = start + (end - start) / 2
            when {
                x > arr[middle] -> start = middle + 1
                x < arr[middle] -> end = middle - 1
                else -> return middle
            }
        }
        return -(end + 2)
    }

    /**
     * Implementation of the binary search that always return very first
     * position of the element.
     */
    fun findFirstOccurrence(arr: IntArray, x: Int): Int {
        if (arr.isEmpty())
            return -1
        var start = 0
        var end = arr.lastIndex
        var result = -1

        while (start <= end) {
            val middle: Int = start + (end - start) / 2
            when {
                x > arr[middle] -> start = middle + 1
                x < arr[middle] -> end = middle - 1
                else -> {
                    result = middle
                    end = middle - 1
                }
            }
        }
        return result
    }

    /**
     * Implementation of the binary search that always return very last
     * position of the element.
     */
    fun findLastOccurrence(arr: IntArray, x: Int): Int {
        if (arr.isEmpty()) {
            return -1
        }
        var start = 0
        var end = arr.lastIndex
        var result = -1

        while (start <= end) {
            val middle: Int = start + (end - start) / 2
            when {
                x > arr[middle] -> start = middle + 1
                x < arr[middle] -> end = middle - 1
                else -> {
                    result = middle
                    start = middle + 1
                }
            }
        }

        return result
    }

    /***
     * Counts occurrences of an element in a sorted array using binary search.
     * Time complexity is O(log(n))
     */
    fun countOccurrences(arr: IntArray, x: Int): Int {
        if (arr.isEmpty()) return 0
        val first = findFirstOccurrence(arr, x)
        if (first == -1) return 0
        val last = findLastOccurrence(arr, x)
        return last - first + 1
    }

    /**
     * Finds how many positions a sorted array elements are shifted (rotated)
     * using binary search.
     * Ex: [2, 3, 4, 1] -> shifted one position
     *
     * NOTE: Array elements should be distinct
     */
    fun countSortedArrayRotations(arr: IntArray): Int {
        if (arr.isEmpty()) return 0
        var low = 0
        var high = arr.lastIndex
        while (low <= high) {
            val middle: Int = low + (high - low) / 2
            val prevIdx = (middle + arr.size - 1) % arr.size
            val nextIdx = (middle + 1) % arr.size
            when {
                // Case 1
                arr[low] < arr[high] -> return low
                // Case 2
                arr[prevIdx] > arr[middle] && arr[nextIdx] > arr[middle] -> {
                    return middle
                }
                // Case 3
                arr[low] > arr[middle] -> high = middle - 1
                // Case 4
                arr[high] < arr[middle] -> low = middle + 1
            }
        }
        return -1
    }

    /**
     * Finds an element in a shifted (rotated) sorted array using binary search.
     * Ex: [2, 3, 4, 1] -> an array shifted one position
     *
     * NOTE: Array elements should be distinct
     */
    fun findElementInCircularlySortedArray(arr: IntArray, x: Int): Int {
        if (arr.isEmpty()) return -1
        var low = 0
        var high = arr.lastIndex
        while (low <= high) {
            val middle = low + (high - low) / 2
            when {
                arr[middle] == x -> return middle
                arr[middle] < arr[high] -> {
                    if (x > arr[middle] && x <= arr[high]) low = middle + 1
                    else high = middle - 1
                }
                else -> {
                    if (x >= arr[low] && x < arr[middle]) high = middle - 1
                    else low = middle + 1
                }
            }
        }
        return -1
    }

    private fun recursiveBinarySearch(
        arr: IntArray,
        x: Int,
        start: Int,
        end: Int
    ): Int {
        if (end < start) return -1
        val middle: Int = start + (end - start) / 2
        return when {
            arr[middle] == x -> return middle
            arr[middle] > x -> recursiveBinarySearch(arr, x, start, middle - 1)
            else -> recursiveBinarySearch(arr, x, start = middle + 1, end = end)
        }
    }
}