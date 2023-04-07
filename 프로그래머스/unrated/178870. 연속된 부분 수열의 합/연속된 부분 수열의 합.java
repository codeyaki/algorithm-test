import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        long total = 0;
        int left = 0;
        List<int[]> list = new LinkedList<>();
        int[] answer = new int[2];
        for(int right = 0; right < sequence.length; right++){
            total += sequence[right];
            // 만약 seqeunce[i]를 더했을때 7이 넘으면 left + 1
            while(total > k && left < right){
                total -= sequence[left++];
            }
            // k와 같다면 stop
            if(total == k){
                list.add(new int[]{left, right});
            }
        }
        Collections.sort(list, (o1, o2) -> (o1[1] - o1[0]) - (o2[1] - o2[0]));
        answer = list.get(0);
        return answer;
    }
}