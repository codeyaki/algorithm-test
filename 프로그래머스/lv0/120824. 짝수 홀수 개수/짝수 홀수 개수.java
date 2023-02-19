import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] cnt = {0, 0};
        Arrays.stream(num_list).forEach(n -> {
            if (n % 2 == 0) cnt[0]++;
            else cnt[1]++;
        });
        return cnt;
    }
}