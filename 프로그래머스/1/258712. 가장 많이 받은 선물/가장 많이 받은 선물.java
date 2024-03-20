import java.util.*;

class Solution {
    private Map<String, Integer> friendMap = new HashMap<>();
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        for(int i = 0; i < n; i++){
            friendMap.put(friends[i], i);
        }
        
        int[][] giftBoard = new int[n][n];
        int[] giftScore = new int[n];
        for(String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            String from = st.nextToken();
            String to = st.nextToken();
            int fromIndex = friendMap.get(from);
            int toIndex = friendMap.get(to);
            giftBoard[fromIndex][toIndex]++;
            giftScore[fromIndex]++;
            giftScore[toIndex]--;
        }
        
        int[] giftReceive = new int[n];
        int answer = 0;
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
            answer = Math.max(answer, giftReceive[i]);
        }
        return answer;
    }
}