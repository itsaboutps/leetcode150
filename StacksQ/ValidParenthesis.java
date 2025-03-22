package StacksQ;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println("Valid Parentheses:: ");
        String s = "[]";
        System.out.print(optimised(s));
        // System.out.print(myApproach(s));

    }

    private static char[] myApproach(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (int i = 0; i < s.length(); i++) {

        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'myApproach'");
    }

    private static boolean optimised(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        java.util.Map<Character, Character> closeToOpen = new java.util.HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();

                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
