object MergeSort {
    fun sort(array: IntArray) {
        val temp = IntArray(array.size)
        internalSort(array, temp, 0, array.size - 1)
    }

    private fun internalSort(array: IntArray, temp: IntArray, left: Int, right: Int) {
        if (left >= right) return
        val mid = (left + right) / 2
        internalSort(array, temp, left, mid)
        internalSort(array, temp, mid + 1, right)
        mergeSortedArray(array, temp, left, mid, right)
    }

    private fun mergeSortedArray(array: IntArray, temp: IntArray, left: Int, mid: Int, right: Int) {
        var i = left
        var j = mid + 1
        var k = 0
        while (i <= mid && j <= right) {
            temp[k++] = if (array[i] < array[j]) array[i++] else array[j++]
        }
        while (i <= mid) {
            temp[k++] = array[i++]
        }
        while (j <= right) {
            temp[k++] = array[j++]
        }
        for (i in 0 until k) {
            array[left + i] = temp[i]
        }
    }
}