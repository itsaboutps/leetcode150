package StacksQ;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println("Generate Parenthesis::");
        int n = 3;
        System.out.print(generateParenthesis(n));
    }

    private static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0,0,n,res,stack);
        return res;
    }

    private static void backtrack(int open, int closed, int n, List<String> res, StringBuilder stack) {

        if (open == closed && open == n) {
            res.add(stack.toString());
            return;
        }

        if (open < n) {
            stack.append('(');
            backtrack(open+1,closed,n,res,stack);
            stack.deleteCharAt(stack.length()-1);
        }
        if (closed < open) {
            stack.append(')');
            backtrack(open, closed + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
