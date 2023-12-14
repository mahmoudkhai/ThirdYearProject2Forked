import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class GraphAlgorithms(numOgVertices: Int) {

    private val adjacentList: Array<MutableList<Int>> = Array(numOgVertices) { mutableListOf() }
    fun addEdge(from: Int, to: Int) {
        adjacentList[from].add(to)
        adjacentList[to].add(from)
    }

    fun breadthFirstSearch(startNode: Int) {
        val visited = BooleanArray(adjacentList.size)
        val queue: Queue<Int> = LinkedList()

        visited[startNode] = true
        queue.add(startNode)

        while (queue.isNotEmpty()) {
            val currentVertex = queue.poll()
            print("$currentVertex")
            for (neighbor in adjacentList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    queue.add(neighbor)
                }
            }
        }
    }
    fun inorderTraversalUsingRecursion(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        inorder(root,res)
        return res
    }

    private tailrec fun inorder(node:TreeNode?, res : MutableList<Int>){
        node?.let{
            inorder(node.left,res)
            res.add(node.`val`)
            inorder(node.right,res)
        }
    }

    fun inorderTraversalUsingStack(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()

        var curr = root
        val stack = Stack<TreeNode>()

        while (curr != null || stack.size != 0) {
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            curr = stack.pop()
            res.add(curr.`val`)
            curr = curr.right
        }
        return res
    }

    /***
     * Given the root of an n-ary tree,
     * return the postorder traversal of its nodes' values.
     */
    fun postorder(root: Node?): List<Int> {
        root ?: return emptyList()
        val list = mutableListOf<Int>()
        handle(root, list)
        list.add(root.`val`)
        return list
    }

    fun postOrderUsingStack(root: Node?): List<Int> {
        val list = mutableListOf<Int>()
        val stack = Stack<Node?>()
        root ?: return emptyList()
        stack.push(root)

        while (!stack.isEmpty()) {
            val node = stack.pop()
            list.add(node?.`val`!!)
            node.children.forEach { stack.push(it) }
        }
        return list.reversed()
    }

    private fun handle(root: Node?, list: MutableList<Int>) {
        root ?: return
        root.children.forEach {
            handle(it, list)
            list.add(it?.`val`!!)
        }
    }
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}