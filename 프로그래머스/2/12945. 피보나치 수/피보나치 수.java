class Solution {
    int[] cache = new int[100001];
    public int solution(int n) {
        cache[0] = 0;
        cache[1] = 1;
        for(int i = 2; i <= n; i++){
            cache[i] = (cache[i-1] + cache[i-2]) % 1234567;
        }
        return cache[n];
    }
}