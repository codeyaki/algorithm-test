class Solution {
    public int solution(int n) {
        int[] cache = new int[60001];
        cache[1] = 1;
        cache[2] = 2;
        for(int i = 3; i <= n; i++) {
            cache[i] = (cache[i-1] + cache[i-2]) % 1000000007;
        }
        return cache[n];
    }
}