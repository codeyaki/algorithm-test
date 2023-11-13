import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> numberMap = new HashMap<>();
        int answer = 0;
        // 무조건 number의 합은 10개
        // want는 1개부터 10개가 됨
        // 즉 10개가 중간에 끊기지 않는다면 정답
        loop:
        for(int left = 0; left < discount.length - 9; left++) {
            Map<String, Integer> hashMap = new HashMap<>();
            
            for(int i = 0; i < want.length; i++){
                numberMap.put(want[i], number[i]);
                hashMap.put(want[i], 0);
            }
            int right;
            for (right = left; right < left + 10; right++) {
                
                String dicountProduct = discount[right];
                // 할인 품목에 없거나 이미 개수를 만족하는 경우
                if(hashMap.getOrDefault(dicountProduct, 1) >= numberMap.getOrDefault(dicountProduct, 0)){
                    continue loop;
                }
                int beforeCount = hashMap.get(dicountProduct);
                hashMap.put(dicountProduct, beforeCount  + 1);
            }
            if(right == left + 10) {
                answer++;
            }
        }
        return answer;
    }
}