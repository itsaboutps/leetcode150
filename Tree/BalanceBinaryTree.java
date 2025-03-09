package Tree;
// https://leetcode.com/problems/balanced-binary-tree/description/
public class BalanceBinaryTree {
    public static void main(String[] args) {
        System.out.println("Diameter of Binary Tree :: ");
    SolutionBruteForce sol = new SolutionBruteForce();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        TreeNode n4 = new TreeNode(4);

        TreeNode n5 = new TreeNode(5);

        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        n3.left = n5;
        System.out.println(sol.isBalanced(n1));
    }
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class SolutionBruteForce {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}