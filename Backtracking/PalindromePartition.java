package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String[] args) {
        System.out.println("Palindrome Partition");
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));
    }
}
class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(s, 0, res, part); // Call dfs with necessary parameters
        return res;
    }

    // dfs is now an instance method
    private void dfs(String s, int i, List<List<String>> res, List<String> part) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(part)); // Add a copy of part to res
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalin(s.substring(i, j + 1))) { // Check if substring is a palindrome
                part.add(s.substring(i, j + 1)); // Add substring to part
                dfs(s, j + 1, res, part); // Recurse
                part.remove(part.size() - 1); // Remove the last element added
            }
        }
    }

    // isPalin is now an instance method
    private boolean isPalin(String s) {
        int left = 0;
        int right = s.length() - 1;

        // Continue looping while the two pointers have not crossed
        while (left < right) {
            // If the characters at the current positions are not equal
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // Move the left pointer to the right and the right pointer to the left
            left++;
            right--;
        }
        // If no mismatch is found, return true (palindrome)
        return true;
    }
}