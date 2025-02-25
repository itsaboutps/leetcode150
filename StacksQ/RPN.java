package StacksQ;

public class RPN {
    public static void main(String[] args) {
        System.out.println("RPN");
        String[] tokens = { "2","1","+","3","*" };

        System.out.println(rpn(tokens));

        // System.out.println(optimsedApproach(tokens));
    }

    private static int optimsedApproach(String[] tokens) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
        // TODO Auto-generated method stub
    }

    private static int rpn(String[] tokens) {

        java.util.Stack<String> stack = new java.util.Stack();
        int val3 = 0;

        for (int i = 0; i < tokens.length; i++) {
            if ((tokens[i] == "+") || (tokens[i] == "-") || (tokens[i] == "*") || (tokens[i] == "/")) {

                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                val3 = 0;
                if ((tokens[i] == "+")) {
                    val3 = val2 + val1;

                } else if (tokens[i] == "-") {
                    val3 = val2 - val1;

                } else if (tokens[i] == "*") {
                    val3 = val2 * val1;

                } else if (tokens[i] == "/") {
                    val3 = val2 / val1;
                }
                String val4 = String.valueOf(val3);

                stack.push(new String(val4));

            } else {
                stack.push(tokens[i]);
                // 2 // 1 // + //
            }
        }
        return val3;
        // TODO Auto-generated method stub
    }
}
