import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] cnt = {0, 0};
        Arrays.stream(num_list).forEach(n -> cnt[n % 2]++);
        return cnt;
    }
}