import java.util.NoSuchElementException

class RecursionExamples {
    /***
     * find the middle node of a list , one pointer is twice faster than the other
     */
    private fun middleNode(head: ListNode?, fast: ListNode? = head): ListNode? =
        if (fast?.next == null) head else middleNode(head?.next, fast?.next?.next)

    /***
     * You need to merge the two trees into a new binary tree.
     * The merge rule is that if two nodes overlap,
     * then sum node values up as the new value of the merged node.
     * https://leetcode.com/problems/merge-two-binary-trees/description/
     */
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null) return root2
        if (root2 == null) return root1
        root1.`val` += root2.`val`
        root1.left = mergeTrees(root1.left, root2.left)
        root1.right = mergeTrees(root1.right, root2.right)
        return root1
    }
    fun findMaxNumberOfList(list: List<Int>): Int {
        if (list.isEmpty()) throw NoSuchElementException("cannot find max of empty list")
        if (list.size == 1) return list[0]

        val first = list.first()
        val rest = list.drop(1)
        val maxNumber = findMaxNumberOfList(rest)

        return if (maxNumber > first) maxNumber else first

    }

    fun countListItems(list: List<Int>): Int {
        if (list.isEmpty()) return 0

        return 1 + countListItems(list.drop(1))
    }

    fun sumOfArrayRecursive(numbers: IntArray): Int {
        return sumOfArrayRecursiveHelper(numbers, numbers.size - 1)
    }

    private fun sumOfArrayRecursiveHelper(numbers: IntArray, index: Int): Int {
        if (index < 0) {
            return 0
        }

        return numbers[index] + sumOfArrayRecursiveHelper(numbers, index - 1)
    }


    /***
     * Binary search algorithm only works with sorted arrays.
     * Complexity: O(log n)
     */
//    fun binarySearch(array: Array<Int> , target: Int): Boolean {
//        //TODO:
//    }
}