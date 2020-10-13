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

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    fun IntArray.isSorted(): Boolean {
        for (i in 0 until lastIndex) {
            if (this[i] > this[i + 1]) return false
        }
        return true
    }
}