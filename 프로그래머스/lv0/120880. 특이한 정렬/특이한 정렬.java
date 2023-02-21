import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist).boxed().sorted((o1, o2) -> {
            int dis1 = Math.abs(o1 - n);
            int dis2 = Math.abs(o2 - n);

            if (dis1 == dis2) {
                return o2 - o1;
            }
            return dis1 - dis2;

        }).mapToInt(Integer::intValue).toArray();

    }

}