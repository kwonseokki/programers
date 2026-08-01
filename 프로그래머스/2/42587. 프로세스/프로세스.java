import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> pQ = new LinkedList<>();

        // [우선순위, 위치]
        for (int i = 0; i < priorities.length; i++) {
            pQ.offer(new int[]{priorities[i], i});
        }

        for (int priority : priorities) {
            maxPq.offer(priority);
        }

        int cnt = 0;

        while (true) {
            // 현재 프로세스가 가장 우선순위가 높다면 실행
            // location이 동일하면 실행 카운트 리턴
            int[] cur = pQ.poll();

            if (maxPq.peek() == cur[0]) {
                cnt++;

                if (cur[1] == location) return cnt;

                // 우선 순위만 제거
                maxPq.poll();                
            } else {
                pQ.offer(cur);
            }
        }
    }
}