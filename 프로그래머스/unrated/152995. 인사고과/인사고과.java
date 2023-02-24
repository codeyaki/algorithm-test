import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int n = scores.length;
        int[] inho = scores[0];
        // 인호가 인센티브를 받을 수 있는지 확인
        if (!check(scores[0], scores)) return -1;
        // 인호보다 높은 성적을 낸 사람중 인센티브를 못받는 사람 확인
        for (int i = 1; i < n; i++) {
            int[] now = scores[i];
            // 인호보다 성적이 좋은 경우
            if (now[0] + now[1] > inho[0] + inho[1]) {
                // 인센티브를 받을 수 없는 사람인 경우 넘어가기
                if (!check(scores[i], scores)) continue;
                answer++;
            }
        }
        return answer;
    }

    boolean check(int[] target, int[][] scores){
        for(int[] member : scores){
            if (target[0] < member[0] && target[1] < member[1]) {
                return false;
            }
        }
        return true;
    }
}