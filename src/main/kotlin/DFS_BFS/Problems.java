package DFS_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class Problems {
    TreeNode ans, target;

    //Recursive Inorder Traversal
    public void inorder(TreeNode o, TreeNode c) {
        if (o != null) {
            inorder(o.left, c.left);
            if (o == target) {
                ans = c;
            }
            inorder(o.right, c.right);
        }
    }

    final TreeNode recursiveInorderTraversal(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return ans;
    }

    final TreeNode iterativeInorderTraversal(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        Deque<TreeNode> stack_o = new ArrayDeque();
        Deque<TreeNode> stack_c = new ArrayDeque();
        TreeNode node_o = original, node_c = cloned;

        while (!stack_o.isEmpty() || node_o != null) {
            while (node_o != null) {
                stack_o.add(node_o);
                stack_c.add(node_c);

                node_o = node_o.left;
                node_c = node_c.left;
            }
            node_o = stack_o.removeLast();
            node_c = stack_c.removeLast();
            if (node_o == target) {
                return node_c;
            }
            node_o = node_o.right;
            node_c = node_c.right;
        }
        return null;
    }

    public final TreeNode BFSIterativeTraversal(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> queue_o = new ArrayDeque();
        queue_o.offer(original);

        Deque<TreeNode> queue_c = new ArrayDeque();
        queue_c.offer(cloned);

        while (!queue_o.isEmpty()) {
            TreeNode node_o = queue_o.poll();
            TreeNode node_c = queue_c.poll();

            if (node_o == target) {
                return node_c;
            }

            if (node_o.left != null) {
                queue_o.offer(node_o.left);
                queue_c.offer(node_c.left);
            }
            if (node_o.right != null) {
                queue_o.offer(node_o.right);
                queue_c.offer(node_c.right);
            }
        }
        return null;
    }

    int sum = 0;


    public int rangeSumBST(TreeNode root, int low, int high) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

        HashMap<TreeNode, Boolean> visitedMap = new HashMap<TreeNode, Boolean>();
        visitedMap.put(root, true);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode value = queue.poll();
            if (!visitedMap.get(value) && visitedMap.get(value) != null) {
                visitedMap.put(value , true);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
                if (value != null && value.val >= low && value.val <= high) {
                    sum += value.val;
                }
            }
        }
        return sum;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int x) {
        val = x;
    }
}
