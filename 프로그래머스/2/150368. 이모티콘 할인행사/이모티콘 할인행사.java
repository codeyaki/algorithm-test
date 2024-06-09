import java.util.*;
// 1. 이모티콘 플러스 서비스 가입자를 늘려라
// 2. 이모티콘 판매액을 최대한 늘려라
class Solution {
    // 사용자는 이모티콘이 할인율을 넘으면 삼
    // 산금액의 총합의 기준을 넘으면 이모티콘 플러스를 삼
    private int[] discountArr = new int[] {10, 20, 30, 40};
    private int n;
    private int[] emoticons;
    private int[] answer = new int[2];
    private int[][] users;
    public int[] solution(int[][] users, int[] emoticons) {
        init(users, emoticons);
        dfs(0 , new int[emoticons.length]);
        return answer;
    }
    
    private void init(int[][] users, int[] emoticons) {
        this.n = users.length;
        this.users = users;
        this.emoticons = emoticons;
    }
    
    private void dfs(int index, int[] discountList) {
        if(index == discountList.length) {
            int countPlus = 0;
            int totalPay = 0;
            // 각 유저별 구매 여부 확인
            for(int i = 0; i < n; i++) {
                int pay = 0;
                for(int e = 0; e < discountList.length; e++) {
                    if(discountList[e] >= users[i][0]) pay += emoticons[e] * ((100F - discountList[e])/100F);
                }
                if(users[i][1] <= pay) countPlus++;
                else totalPay += pay;
            }
            
            if(answer[0] < countPlus) {
                answer[0] = countPlus;
                answer[1] = totalPay;
            } else if (answer[0] == countPlus) {
                answer[1] = Math.max(answer[1], totalPay);
            }
            return;
        }
        
        // 할인 선택하기
        for(int dis : discountArr) {
            discountList[index] = dis;
            dfs(index + 1, discountList);
        }
    
    }
}