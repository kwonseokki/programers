import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        // "(())()"
        // 괄호가 열려있을때 닫힌 괄호가 들어온다
        // 스택이 비어있다면 올바른 괄호
        for (char  c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty();
    }
}