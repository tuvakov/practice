package algorithms

object Sorting {

    fun selectionSort(arr: IntArray) {
        for (i in 0 until arr.lastIndex) {
            var minIdx = i
            for (j in i + 1..arr.lastIndex) {
                if (arr[j] < arr[minIdx])
                    minIdx = j
            }
            swap(arr, i, minIdx)
        }
    }

    fun bubbleSort(arr: IntArray) {
        for (i in 0..arr.lastIndex) {
            var swapFlag = false
            for (j in 0 until arr.lastIndex - i) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1)
                    swapFlag = true
                }
            }
            // No swaps means, the array is already sorted
            if (!swapFlag) break
        }
    }

    fun insertionSort(arr: IntArray) {
        for (i in 1..arr.lastIndex) {
            var j = i
            while (j >= 1 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1)
                --j
            }
        }
    }

    fun mergeSort(arr: IntArray) {
        mergeSortInternal(arr)
    }

    private fun mergeSortInternal(arr: IntArray) {
        if (arr.size < 2)
            return

        val middle: Int = arr.size / 2
        val left = arr.copyOfRange(0, middle)           // [start, end)
        val right = arr.copyOfRange(middle, arr.size)

        mergeSortInternal(left)
        mergeSortInternal(right)
        merge(left, right, arr)
    }

    private fun merge(left: IntArray, right: IntArray, arr: IntArray) {
        var l = 0
        var r = 0
        var k = 0

        while (l < left.size && r < right.size) {
            arr[k++] = if (left[l] <= right[r]) left[l++] else right[r++]
        }

        while (l < left.size) {
            arr[k++] = left[l++]
        }

        while (r < right.size) {
            arr[k++] = right[r++]
        }
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    /* Extensions */

    fun IntArray.isSorted(): Boolean {
        for (i in 0 until lastIndex) {
            if (this[i] > this[i + 1]) return false
        }
        return true
    }
}