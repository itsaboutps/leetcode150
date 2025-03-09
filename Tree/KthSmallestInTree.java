package Tree;

import java.util.*;
// https://leetcode.com/problems/kth-smallest-element-in-a-bst

public class KthSmallestInTree {
    public static void main(String[] args) {
        System.out.println("");
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
//! BRUTE FORCE APPROACH
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = 
        levelOrder(root);

        Collections.sort(list);

        return list.get(k-1);
    }

    List<Integer> levelOrder(TreeNode root) {
    // Initialize queue, add root node
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    // Initialize a list to store the traversal sequence
    List<Integer> list = new ArrayList<>();
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // Queue dequeues
        list.add(node.val);           // Save node value
        if (node.left != null)
            queue.offer(node.left);   // Left child node enqueues
        if (node.right != null)
            queue.offer(node.right);  // Right child node enqueues
    }
    return list;
}
}