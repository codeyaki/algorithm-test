import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> factor = new ArrayList<>();
        int d = 2;
        while (n > 1) {
            if (n % d == 0) {
                factor.add(d);
                n /= d;
            } else {
                d++;
            }
        }
        return factor.stream().distinct().mapToInt(Integer::new).toArray();
    }
}