import java.util.*;

class Solution {

    public String solution(int n, int t, int m, int p) {
        // 구해야하는 총 자리수
        int targetLength = m * t;
        
        // 구해야 하는 자리수까지 n진법을 이어 붙이기
        String totalString = getTotalStrig(n, targetLength);
        
        // 튜브가 말해야하는 숫자 구하기

        return getTubeSayString(totalString, t, m, p);
    }
    private String getTotalStrig(int n, int targetLength){
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while(result.length() <= targetLength){
            result.append(Integer.toString(i, n));
            i++;
        }
        return result.toString().toUpperCase();
    }
    
    private String getTubeSayString(String totalString,int t, int m, int p){
        StringBuilder result = new StringBuilder();
        for(int i = p - 1; i < t * m + p - 1; i += m){
            result.append(totalString.charAt(i));
        }
        return result.toString();
    }
}
