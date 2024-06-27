/**
 * 1. 가장 먼곳부터 배달 최대치 챙기기
 * 2. 가장 먼곳부터 수거 최대치 챙기기
 *   2-a. 배달거리보다 먼 거리의 수거가 생길 수도 있음
 * 3. 즉,배달과 수거를 비교해서 가장 먼곳을 더하자.
 * 시간 복잡도를 줄이기 위해서 미리 cap의 용량만큼 포장해놓으면 좋나?
 */
import java.util.*;

class Solution {
    Stack<int[]> deliveryStack = new Stack<>();
    Stack<int[]> pickupStack = new Stack<>();
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        for (int d = 0; d < n; d++) {
            if(deliveries[d] > 0) deliveryStack.push(new int[]{deliveries[d], d + 1});
            if(pickups[d] > 0) pickupStack.push(new int[]{pickups[d], d + 1});
        }
        
        
        while(!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            int tempCap = cap;
            // 가장 먼곳부터 배달할수있는 만큼 배달하기
            int maxDist = 0;
            while (!deliveryStack.isEmpty() && tempCap > 0) {
                int[] deliveryHouse = deliveryStack.pop();
                tempCap -= deliveryHouse[0];
                maxDist = Math.max(deliveryHouse[1], maxDist);
                // 더 많이 가져간 경우 남는거 반납
                if(tempCap < 0) {
                    deliveryHouse[0] = -tempCap;
                    deliveryStack.push(deliveryHouse);
                }
            }
            
            // 가장 먼곳부터 픽업할수있는 만큼 픽업하기
            tempCap = cap;
            while (!pickupStack.isEmpty() && tempCap > 0) {
                int[] pickupHouse = pickupStack.pop();
                tempCap -= pickupHouse[0];
                maxDist = Math.max(pickupHouse[1], maxDist);
                // 더 많이 가져간 경우 남는거 반납
                if(tempCap < 0) {
                    pickupHouse[0] = -tempCap;
                    pickupStack.push(pickupHouse);
                }
            }
            answer += maxDist * 2;
        }
        return answer;
    }
}