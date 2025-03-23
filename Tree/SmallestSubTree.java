package Tree;

public class SmallestSubTree {
    
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root, 0)[0];
    }


    private TreeNode[] dfs(TreeNode node, int depth){
            if(node == null){
                return new TreeNode[]{null, new TreeNode(depth)}; // store depth in a treeNode
            }

            TreeNode[] left = dfs(node.left, depth+1);
            TreeNode[] right = dfs(node.right, depth+1);


            if(left[1].val == right[1].val)
            {
                return new TreeNode[]{node,left[1]};
            }
            return left[1].val > right[1].val ? left:right;


    }
}