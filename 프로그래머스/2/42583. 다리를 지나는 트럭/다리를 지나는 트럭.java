import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalTruckWeight = 0, remainTruckWeight = 0, goOverTruckWeight = 0;

        Queue<Integer> remainTrucks = new LinkedList<>();
        Queue<Integer> bridgeQueue = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(-1);
        }

        // 트럭 배열을 큐로 변환
        for (int truckWeight: truck_weights) {
            remainTrucks.offer(truckWeight);
            totalTruckWeight += truckWeight;
        }
        remainTruckWeight = totalTruckWeight;

        int moveCount = 0;

        while (!(goOverTruckWeight == totalTruckWeight)) {
            int currentTruckWeight = bridgeQueue.remove();
            // 트럭이 다리를 건넌다
            if (currentTruckWeight != -1) {
                goOverTruckWeight += currentTruckWeight;
            }

            // 트럭이 다리를 건너고나서 현재 다리의 무게를 계산
            int currentbridgeWeight = totalTruckWeight - remainTruckWeight - goOverTruckWeight;

            if (!remainTrucks.isEmpty() && remainTrucks.peek() + currentbridgeWeight <= weight) {
                // 새로운 트럭이 다리를 건넘
                int currentRemainTruck = remainTrucks.remove();
                bridgeQueue.offer(currentRemainTruck);
                remainTruckWeight -= currentRemainTruck;
            } else {
                bridgeQueue.offer(-1);
            }
            moveCount += 1;
        }

        return moveCount;
    }
}