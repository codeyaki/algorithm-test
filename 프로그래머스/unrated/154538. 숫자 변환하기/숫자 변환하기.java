import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        int[] cache = new int[y + 1];
        for (int i = 0; i < x; i++) {
            cache[i] = -1;
        }
        cache[x] = 0;
        for (int i = x + 1; i < y + 1; i++) {
            int[] tmpResult = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
            // 2 곱하기
            if (i % 2 == 0 && cache[i / 2] >= 0) tmpResult[0] = cache[i / 2] + 1;
            // 3 곱하기
            if (i % 3 == 0 && cache[i / 3] >= 0) tmpResult[1] = cache[i / 3] + 1;
            // n 더하기
            if (i - n >= 0 && cache[i - n] >= 0) tmpResult[2] = cache[i - n] + 1;
            int min = Arrays.stream(tmpResult).min().getAsInt();
            cache[i] = min == Integer.MAX_VALUE ? -1 : min;
        }


        return cache[y];
    }
}