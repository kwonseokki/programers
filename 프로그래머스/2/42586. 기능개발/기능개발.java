import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> answer = new ArrayList<>();
        
        int deployCount = 0;
        for (int i = 0; i < progresses.length; i++) {
            deployCount += 1;
            int deployTime = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

            for (int j = i + 1; j < progresses.length; j++) {
                if (progresses[j] + deployTime * speeds[j] >= 100) {
                    deployCount += 1;
                    i += 1;
                } else {
                    break;
                }
            }

            answer.add(deployCount);
            deployCount = 0;
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}