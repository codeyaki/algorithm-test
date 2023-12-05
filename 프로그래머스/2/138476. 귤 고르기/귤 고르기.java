import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            int num = tangerine[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        int answer = 0;
        for(int n : keys){
            k -= map.get(n);
            answer++;
            if(k <= 0) break;
        }
        return answer;
    }
}