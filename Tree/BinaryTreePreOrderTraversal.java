package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
        public static void main(String[] args) {
        System.out.println("binary-tree-preorder-traversal");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        PreorderTraversalClass solution = new PreorderTraversalClass();
        List<Integer> result = solution.preorderTraversal(root);
        System.out.println(result);
        }
}

/*
* https://leetcode.com/problems/binary-tree-preorder-traversal/
The idea is:

First push the root node into the stack

Pop an element from the stack and push the right node and the left node into the stack in sequence

Repeat step 2

 
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
class PreorderTraversalClass {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();


        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                result.add(root.val); // adding root value
                stack.push(root); // pushing root to stack
                root = root.left; // moving to left
            }

            root = stack.pop().right; // moving to right
        }

        return result;

    }
}