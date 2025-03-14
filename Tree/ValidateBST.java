package Tree;

public class ValidateBST {
    public static void main(String[] args) {
        System.out.println("Vaidate BST");
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
class SolutionValidateBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long left, long right){
        if(root==null){
            return true;
        }
        if(!(root.val < right && root.val>left)){
            return false;
        }
        
        return dfs(root.left, left,root.val) && dfs(root.right, root.val, right);

    }
}