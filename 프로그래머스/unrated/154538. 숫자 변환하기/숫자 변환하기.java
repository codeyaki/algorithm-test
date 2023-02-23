import java.util.Arrays;

class Solution {
    int x, y, n;
    int[] cache;

    public int solution(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
        cache = new int[y * 3 + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[x] = 0;
        for (int i = x; i < y + 1; i++) {
            if (cache[i] != Integer.MAX_VALUE) {
                // 2 곱하기
                cache[i * 2] = Math.min(cache[i] + 1, cache[i * 2]);
                // 3 곱하기
                cache[i * 3] = Math.min(cache[i] + 1, cache[i * 3]);
                // n 더하기
                cache[i + n] = Math.min(cache[i] + 1, cache[i + n]);
            }
        }
        return cache[y] == Integer.MAX_VALUE ? -1 : cache[y];
    }
}