package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepth {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Recursive DFS
        System.out.println(maxDepthRecursive(root));

        // Iterative BFS
        System.out.println(maxDepthIterative(root));

        // Iterative DFS
        System.out.println(maxDepthDfsIterative(root));

    }

    private static int maxDepthDfsIterative(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int res = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int depth = current.getValue();

            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new Pair<>(node.left, depth + 1));
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }
        return res;

    }

    private static int maxDepthRecursive(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));

        // TODO Auto-generated method stub
    }

    private static int maxDepthIterative(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.add(root);
        }
        int level = 0;

        while (!(q.isEmpty())) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;

        }
        return level;

        // TODO Auto-generated method stub
    }
}