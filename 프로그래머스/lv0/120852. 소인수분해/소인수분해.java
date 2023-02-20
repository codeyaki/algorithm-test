import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> factor = new ArrayList<>();
        while (n > 1) {
            for (int i = 2; i < n + 1; i++) {
                if (n % i == 0) {
                    factor.add(i);
                    n /= i;
                    break;
                }
            }
        }
        return factor.stream().distinct().mapToInt(Integer::new).toArray();
    }
}