fun binarySearchRecurs(list: List<Int>, target: Int): Int {
    return recursiveBinarySearch(list, target, 0, list.size - 1)
}

/***
 * complexity = O(log n)
 */
fun recursiveBinarySearch(list: List<Int>, target: Int, left: Int, right: Int): Int {
    if (left > right) {
        return -1
    }

    val mid = (left + right) / 2
    val midValue = list[mid]

    return when {
        target == midValue -> mid
        target < midValue -> recursiveBinarySearch(list, target, left, mid - 1)
        else -> recursiveBinarySearch(list, target, mid + 1, right)
    }
}

/***
 * Binary search Algorithm.
 * Complexity: O(N)
 */
fun normalBinarySearch(list: List<Int>, target: Int): Int {
    var left = 0
    var right = list.size - 1

    while (left <= right) {
        val mid = (left + right) / 2
        val midValue = list[mid]

        when {
            target == midValue -> return mid
            target < midValue -> right = mid - 1
            else -> left = mid + 1
        }
    }

    return -1
}