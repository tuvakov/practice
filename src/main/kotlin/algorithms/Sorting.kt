package algorithms

import java.util.*

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
        MergeSort.sort(arr)
    }

    fun quickSort(arr: IntArray) {
        QuickSort.sort(arr)
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    private object MergeSort {
        fun sort(arr: IntArray) {
            if (arr.size < 2)
                return

            val middle: Int = arr.size / 2
            val left = arr.copyOfRange(0, middle)           // [start, end)
            val right = arr.copyOfRange(middle, arr.size)

            sort(left)
            sort(right)
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
    }

    private object QuickSort {
        fun sort(arr: IntArray) {
            arr.shuffle()
            sort(arr, 0, arr.lastIndex)
        }

        private fun sort(arr: IntArray, start: Int, end: Int) {
            if (start >= end) return
            val partitionIdx = partition(arr, start, end)
            sort(arr, start, partitionIdx - 1)
            sort(arr, partitionIdx + 1, end)
        }

        private fun partition(arr: IntArray, start: Int, end: Int): Int {
            val pivot = arr[end]
            var partitionIdx = start
            for (i in start until end) {
                if (arr[i] <= pivot) {
                    swap(arr, partitionIdx, i)
                    ++partitionIdx
                }
            }
            swap(arr, partitionIdx, end)
            return partitionIdx
        }
    }

    /* Extensions */

    fun IntArray.isSorted(): Boolean {
        for (i in 0 until lastIndex) {
            if (this[i] > this[i + 1]) return false
        }
        return true
    }

    fun IntArray.shuffle() {
        val random = Random()
        for (i in lastIndex downTo 0) {
            val randIdx = random.nextInt(i + 1)
            swap(this, i, randIdx)
        }
    }
}