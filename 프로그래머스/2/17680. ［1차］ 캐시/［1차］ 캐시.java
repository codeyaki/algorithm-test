import java.util.*;

class Solution {
    private int TIME_CACHE_HIT = 1;
    private int TIME_CACHE_MISS = 5;
    private List<String> cache = new LinkedList<>();
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0 ) return cities.length * TIME_CACHE_MISS;
        int answer = 0;
    
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            
            if(cache.contains(city)) {
                // 캐시 적중시
                answer += TIME_CACHE_HIT;
                cache.remove(city);
                cache.add(city);
            } else {
                // 캐시 미적중시
                answer += TIME_CACHE_MISS;
                if(cache.size() >= cacheSize) cache.remove(0);
                cache.add(city);
            }
        }
        return answer;
        
    }
}