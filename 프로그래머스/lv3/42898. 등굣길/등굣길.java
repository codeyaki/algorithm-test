class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] cntArr = new int[n][m];
        // 물 웅덩이 배치
        for (int i = 0; i < puddles.length; i++) {
            cntArr[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        // 초기화
        cntArr[0][0] = 1;
        for (int i = 1; i < n; i++) {
            // 물웅덩일 경우 넘어가기
            if (cntArr[i][0] == -1) {
                cntArr[i][0] = 0;
                continue;
            }
            cntArr[i][0] = cntArr[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            if (cntArr[0][i] == -1) {
                cntArr[0][i] = 0;
                continue;
            }
            cntArr[0][i] = cntArr[0][i - 1];
        }
        // dp
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 물웅덩일 경우 넘어가기
                if (cntArr[i][j] == -1) {
                    cntArr[i][j] = 0;
                    continue;
                }
                cntArr[i][j] = (cntArr[i - 1][j] + cntArr[i][j - 1]) % 1000000007;
            }
        }
        return cntArr[n - 1][m - 1] % 1000000007;
    }
}