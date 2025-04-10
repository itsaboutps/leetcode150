import java.util.Stack;
// https://leetcode.com/problems/longest-valid-parentheses/
class LongestValidParenthesis{
    public static void main(String[] args) {
        System.out.println("LongestValidParenthesis");
        String s = "(()))())(";
        LongestValidParenthesis solution = new LongestValidParenthesis();
        int result = solution.longestValidParentheses(s);
        System.out.println(result); // Output: 4
    }

    private int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && st.peek() != -1 && s.charAt(st.peek()) == '(') {
                st.pop();
                ans = Math.max(ans, i - st.peek());
            } else {
                st.push(i);
            }
        }

        return ans;
    }
}


