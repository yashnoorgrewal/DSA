import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        // Use a stack to build the smallest number
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            // While the stack is not empty, we have removals left, and the
            // top of the stack is greater than the current digit, pop from the stack.
            // This ensures the digits on the stack are in non-decreasing order.
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // If k is still greater than 0, it means the digits were already
        // in non-decreasing order (e.g., "12345"), so we need to remove the
        // remaining largest digits from the end of the stack.
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Rebuild the number from the stack.
        // The stack is in reverse order (smallest digits on the bottom).
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        // Remove any leading zeros. For example, "001" should be "1".
        // The loop continues as long as there's more than one digit and the
        // first digit is '0'.
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If the resulting string is empty, the result is "0".
        // Otherwise, return the string.
        return sb.length() == 0 ? "0" : sb.toString();
    }
}