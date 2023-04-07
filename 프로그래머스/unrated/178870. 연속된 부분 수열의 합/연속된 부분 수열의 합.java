import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        long total = 0;
        int left = 0;
        List<int[]> list = new LinkedList<>();
        int[] answer = new int[]{0, sequence.length};
        for(int right = 0; right < sequence.length; right++){
            total += sequence[right];
            // 만약 seqeunce[i]를 더했을때 7이 넘으면 left + 1
            while(total > k && left < right){
                total -= sequence[left++];
            }
            // k와 같다면 정답이 될 수 있는지 비교
            if(total == k){
                if((answer[1] - answer[0]) > (right - left)){
                    answer = new int[]{left, right};
                }
            }
        }
        return answer;
    }
}