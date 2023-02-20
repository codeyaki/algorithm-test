class Solution {
    public int[][] solution(int[] num_list, int n) {
        int length = num_list.length;
        int[][] answer = new int[length / n][n];
        int index = 0;
        for (int i = 0; i < length / n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = num_list[index++];
            }
        }
        return answer;
    }
}