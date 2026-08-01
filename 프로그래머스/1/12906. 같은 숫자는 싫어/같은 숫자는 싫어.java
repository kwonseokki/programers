import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arrList.isEmpty() || arr[i] != arrList.get(arrList.size() - 1)) {
                arrList.add(arr[i]);
            }
        }

        return arrList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}