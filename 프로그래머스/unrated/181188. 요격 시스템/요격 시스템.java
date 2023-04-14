import java.util.*;

class Solution {
    private boolean[] isIntercept;
    public int solution(int[][] targets) {
        isIntercept = new boolean[targets.length];
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        Queue<int[]> que = new LinkedList<>(List.of(targets));
        int answer = 0;
        while(!que.isEmpty()){
            // 요격 해야할 미사일
            int[] missile = que.poll();
            answer++;
            // 만약 동시에 요격할 수 있는 미사일이 있는 경우
            int[] nextMissile = que.peek();
            while(!que.isEmpty() && missile[1] > nextMissile[0]){
                que.poll();
                nextMissile = que.peek();
            }
        }
        return answer;
    }
}