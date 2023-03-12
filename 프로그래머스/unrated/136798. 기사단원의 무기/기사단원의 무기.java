class Solution {
    int[] cntDivisor;
    final int N = 100000;

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += cntDivisor[i] > limit ? power : cntDivisor[i];
        }
        return answer;
    }

    public Solution() {
        cntDivisor = new int[N + 1];
        cntDivisor[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            cntDivisor[i] += 2;
            for (int j = i * 2; j < N + 1; j += i) {
                cntDivisor[j] += 1;
            }
        }
    }
}