import java.util.*;

class Solution {
    int[] maxRes = new int[]{-1};
    int maxScore = 1;
    public int[] solution(int n, int[] info) {
        search(0, n, info, new int[info.length], 0);
        return maxRes;
    }
    
    void search(int index, int n, int[] info, int[] res, int score) {
        if(index >= 10) {
            // 남은 탄환은 전부 마지막에 박아버리기
            res[index] = n;
            if(maxScore <= score) {
                // 둘중 낮은 점수에 더 많이 쏜거 고르기
                if(maxScore == score && !isMoreRowHit(maxRes, res)) return;
                maxRes = res.clone();
                maxScore = score;
            }
            return;
        }
        // 점수 획득해야 하는 경우
        int need = info[index] + 1;
        if(n - need >= 0) {
            res[index] = need;
            search(index + 1, n - res[index], info, res, score + (10 - index));
        }
        // 점수 획득 포기
        res[index] = 0;
        // 패배
        if(info[index] > 0) search(index + 1, n, info, res, score - (10 - index));
        // 무승부
        else search(index + 1, n, info, res, score);
    }
    
    private boolean isMoreRowHit(int[] a1, int[] a2) {
        for(int i = 10; i >= 0; i--) {
            if(a1[i] > 0) return false;
            if(a2[i] > 0) return true;
        }
        return false;
    }
}