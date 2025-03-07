package Tree;

public class DiameterOfBinaryT {

    public static void main(String[] args) {
        System.out.println("Diameter of Binary Tree :: ");
        SolutionT sol = new SolutionT();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        TreeNode n4 = new TreeNode(4);

        TreeNode n5 = new TreeNode(5);

        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        n3.left = n5;
        System.out.println(sol.diameterOfBinaryTree(n1));
        
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class SolutionT {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;

    }

    //calculate the height
    public int dfs(TreeNode curr) {

        if (curr == null) {
            return 0;
        }
        int left = dfs(curr.left);
        int right = dfs(curr.right);
        result = Math.max(result, left + right);
        return 1 + Math.max(left, right);

    }
}