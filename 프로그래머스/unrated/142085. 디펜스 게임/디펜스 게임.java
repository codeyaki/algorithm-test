import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = -1;
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0; i < enemy.length; i++){
            // 일단 병사로 막기
            n -= enemy[i];
            que.add(enemy[i]);
            answer = i + 1;
            // 게임이 오버되면
            if(n < 0){
                // 무적권 사용
                if(k > 0 && !que.isEmpty()){
                    int rollback = que.poll();
                    n += rollback;
                    k--;
                }else{
                    // 되돌릴 라운드가 없거나 무적권을 모두 사용했을 경우
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}