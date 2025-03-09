package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LinkedList.ListNode;

public class BinaryTRightSide {
    public static void main(String[] args) {
        System.out.println("Binary Tree Right Side");
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();


        q.offer(root);
        if(root ==null){
            return result;
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i =0;i<size;i++){
                TreeNode curr_node = q.poll();
                if(i==0){
                    result.add(curr_node.val);
                }
                if(curr_node.right!=null)q.offer(curr_node.right);
                if(curr_node.left!=null)q.offer(curr_node.left);

            }
        }
        return result;
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

 class SolutionDFS {
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        
        if (res.size() == depth) {
            res.add(node.val);
        }
        
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}