class Solution {
    public long solution(int[] sequence) {
        // i에서 자신이 플러스인 경우, 마이너스인 경우로 생각
        // 플러스인 경우 전 인덱스는 마이너스야 함
        long[][] cache = new long[sequence.length][2];
        cache[0][0] = sequence[0];
        cache[0][1] = -sequence[0];
        long answer = Math.max(cache[0][0], cache[0][1]);
        for (int i = 1; i < sequence.length; i++) {
            // 자신이 플러스인 경우
            cache[i][0] = Math.max(cache[i - 1][1] + sequence[i], sequence[i]);
            answer = Math.max(answer, cache[i][0]);
            // 자신이 마이너스인 경우
            cache[i][1] = Math.max(cache[i - 1][0] - sequence[i], -sequence[i]);
            answer = Math.max(answer, cache[i][1]);
        }
        return answer;
    }

}