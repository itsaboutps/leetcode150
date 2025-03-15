package Backtracking;

import java.util.*;

public class CombinationOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println("Combination of Phone Number");
        // System.out.println(letterCombinations("234"));

        UsingBacktracking usingBacktracking = new UsingBacktracking();
        System.out.println(usingBacktracking.letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        res.add("");
        String[] digitToChar = {
                "", "", "abc", "def", "ghi", "jkl",
                "mno", "qprs", "tuv", "wxyz"
        };

        for (char digit : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String curStr : res) {
                for (char c : digitToChar[digit - '0'].toCharArray()) {
                    tmp.add(curStr + c);
                }
            }
            res = tmp;
        }
        return res;
    }
}

class UsingBacktracking {

    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;
        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, curStr + c, digits);
        }
    }
}