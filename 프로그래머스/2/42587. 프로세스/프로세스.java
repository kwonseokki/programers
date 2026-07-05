import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
            pq.add(priorities[i]);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();

            if (cur[0] == pq.peek()) {
                count++;
                pq.remove();
                if (cur[1] == location) break;
            } else {
                queue.add(cur);
            }
        }
        
        return count;
    }
}