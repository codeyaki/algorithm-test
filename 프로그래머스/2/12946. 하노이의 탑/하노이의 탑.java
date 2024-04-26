import java.util.*;

class Solution {
    private List<int[]> answerList = new LinkedList<>();
    public int[][] solution(int n) {
        int[][] answer = {};
        move(n, 1, 2, 3);
        return answerList.stream().toArray(int[][]::new);
    }
    
    private void move(int n, int start, int mid, int end) {
        if(n == 1){
            answerList.add(new int[]{start, end});
            return;
        }
        move(n - 1, start, end, mid);
        move(1, start, mid, end);
        move(n - 1, mid, start, end);
    }
}