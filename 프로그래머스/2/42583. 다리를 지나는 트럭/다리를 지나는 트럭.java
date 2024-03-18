import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        Queue<Integer> waiting = new LinkedList<>();
        int totalWeight = 0;
        int totalCount = 0;
        for(int truckWeight : truck_weights) {
            waiting.add(truckWeight);
        }
        int currentTime = 1;
        while(!waiting.isEmpty()){    
            // 다리에 트럭 있으면 한대 빼기
            if(!bridge.isEmpty()) {
                Truck out = bridge.poll();
                currentTime = Math.max(out.enterTime + bridge_length, currentTime);
                totalWeight -= out.weight;
                totalCount--;
            }
            // 빠진 차만큼 트럭 추가
            while(!waiting.isEmpty() 
                  && totalWeight + waiting.peek() <= weight 
                  && totalCount + 1 <= bridge_length ){
                int next = waiting.poll();
                bridge.add(new Truck(next, currentTime++));
                totalCount++;
                totalWeight += next;
            }
        }
        // 1. 기다리는 트럭이 없으면 그대로 다리에남은 모든 트럭 내보내기
        while(!bridge.isEmpty()) {
            Truck lastTruck = bridge.poll();
            currentTime = lastTruck.enterTime + bridge_length;
        }
        return currentTime;
    }
    
    class Truck{
        int weight;
        int enterTime;
        public Truck(int weight, int enterTime){
            this.weight = weight;
            this.enterTime = enterTime;
        }
    }
}