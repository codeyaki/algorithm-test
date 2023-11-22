class Solution {
    public int solution(int n, int[][] results) {
        int[][] scoreArr = new int[n + 1][n + 1];
        for(int[] result : results) {
            scoreArr[result[0]][result[1]] = 1; // 승
            scoreArr[result[1]][result[0]] = -1; // 패
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++){
                for(int k = 1; k < n + 1; k++){
                    if(scoreArr[i][k] == 1 && scoreArr[k][j] == 1) {
                        scoreArr[i][j] = 1;
                        scoreArr[j][i] = -1;
                    }
                    if(scoreArr[i][k] == -1 && scoreArr[k][j] == -1) {
                        scoreArr[i][j] = -1;
                        scoreArr[j][i] = 1;
                    }
                }
            }
        }
        // 이제 자기 자신을 제외한 나머지 선수와의 전적을 알면 해당 선수의 순위 확인 가능
        int answer = 0;
        for (int i = 1; i < n + 1; i++){
            int count = 0;
            for (int j = 1; j < n + 1; j++){
                if(scoreArr[i][j] == 1 || scoreArr[i][j] == -1) count++;
            }
            if(count == n - 1) answer++;
        }
        return answer;
    }
}