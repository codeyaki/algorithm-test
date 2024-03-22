import java.util.*;

class Solution {
    private Set<Integer> numberSet = new HashSet<>();
    private boolean[] isVisited;
    private boolean[] isNotPrime;
    public int solution(String numbers) {
        isVisited = new boolean[numbers.length()];
        dfs(0, "", numbers.split(""));
        int max = getMaxNum(numberSet);
        isNotPrime = new boolean[max + 1];
        checkPrime(max);
        
        int answer = getCountPrime();
        return answer;
    }
    
    private int getCountPrime() {
        int answer = 0;
        for (int num : numberSet) {
            if(!isNotPrime[num]) answer++;
        }
        return answer;
    }
    private void checkPrime(int num) {
        isNotPrime[0] = isNotPrime[1] = true;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(isNotPrime[i]) continue;
            // 소수의 배수 제거
            for(int j = i*2; j <= num; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
    
    private int getMaxNum(Set<Integer> set) {
        int max = 0;
        for (int num : set) {
            max = Math.max(num, max);
        }
        return max;
    }
    
    private void dfs(int nowIndex,String now, String[] numbers) {
        if(now.length() > numbers.length) {
            return;
        }
        for(int i = 0; i < numbers.length; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            numberSet.add(Integer.parseInt(now + numbers[i]));
            dfs(i, now + numbers[i], numbers);
            isVisited[i] = false;
        }        
    }
}