package Tree;

public class GoodNode {
    public static void main(String[] args) {
        System.out.println("GoodNode ");
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
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }

    public int dfs(TreeNode node, int maxSoFar){
        int res = 0;
        if(node == null){
            return 0;
        }

        if(node.val >= maxSoFar){
            res = 1;
        }else{
            res = 0;
        }
        maxSoFar = Math.max(maxSoFar, node.val);
        res+=dfs(node.left, maxSoFar);
        res+=dfs(node.right, maxSoFar);
    return res;
    }
}
