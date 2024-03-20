import java.util.*;

class Solution {
    private Map<String, Integer> friendMap = new HashMap<>();
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        for(int i = 0; i < n; i++){
            friendMap.put(friends[i], i);
        }
        
        int[][] giftBoard = new int[n][n];
        for(String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            String from = st.nextToken();
            String to = st.nextToken();
            int fromIndex = friendMap.get(from);
            int toIndex = friendMap.get(to);
            giftBoard[fromIndex][toIndex]++;
        }
        
        int[] giftScore = new int[n];
        // 선물 지수 계산
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                giftScore[i] += giftBoard[i][j] - giftBoard[j][i];
            }
        }
        // 선물을 주고받지 않은 경우나 같은 경우
        int[] giftReceive = new int[n];
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(giftBoard[i][j] > giftBoard[j][i]) giftReceive[i]++;
                else if(giftBoard[i][j] < giftBoard[j][i]) giftReceive[j]++;
                else {
                    // 선물 횟수가 같으면 지수 비교
                    if(giftScore[i] > giftScore[j]) giftReceive[i]++;
                    else if(giftScore[i] < giftScore[j]) giftReceive[j]++;
                }
            }
        }
        return getMax(giftReceive);
    }
    
    private int getMax(int[] arr) {
        int max = 0;
        for(int num : arr) {
            max = Math.max(num, max);
        }
        return max;
    }
}