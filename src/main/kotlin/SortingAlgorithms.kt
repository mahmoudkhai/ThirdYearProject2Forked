class SortingAlgorithms {
    /***
     *not support duplicates
     * complexity: O(n log n)
     */
    fun quickSort(array: IntArray): IntArray {
        if (array.size < 2) return array
        else {
            val pivot = array[0]
            val lessThanPivot = array.filter { it < pivot }.toIntArray()
            val greaterThanPivot = array.filter { it > pivot }.toIntArray()
            return quickSort(lessThanPivot) + pivot + quickSort(greaterThanPivot)
        }
    }

    /***
     * Selection Sort Algorithm.
     * Complexity: O(n^2).
     */
    fun selectionSort(array: IntArray) {
        val n = array.size

        for (i in 0 until n - 1) {
            var minIndex = i

            for (j in i + 1 until n) {
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }

            if (minIndex != i) {
                array.swap(i, minIndex)
            }
        }
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

}