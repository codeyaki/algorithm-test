import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int block : section){
            queue.offer(block - 1);
        }
        while(!queue.isEmpty()){
            Integer paintStart = queue.poll();
            while(!queue.isEmpty() && paintStart + m > queue.peek()) queue.poll();
            answer++;
        }
        return answer;
    }
}