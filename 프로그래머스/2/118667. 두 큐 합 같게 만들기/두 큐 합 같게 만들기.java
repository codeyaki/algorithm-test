import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
            sum1 += queue1[i];
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }
        long target = (sum1 + sum2) / 2;
        while(sum1 != target) {
            answer++;
            if(answer > queue1.length * 3) return -1;
            if(sum1 > target) {
                int num = que1.poll();
                sum1 -= num;
                que2.add(num);
                sum2 += num;
            } else {
                int num = que2.poll();
                sum2 -= num;
                que1.add(num);
                sum1 += num;
            }
        }
        return answer;
    }
}