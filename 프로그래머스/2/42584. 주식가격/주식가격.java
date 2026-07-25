import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> pStack = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!pStack.isEmpty() && prices[pStack.peek()] > prices[i]) {
                int index = pStack.pop();
                answer[index] = i - index;
            }
            
            pStack.push(i);
        }

        while (!pStack.isEmpty()) {
            int index = pStack.pop();
            answer[index] = (prices.length - 1) - index;
        }
        
        return answer;
    }
}