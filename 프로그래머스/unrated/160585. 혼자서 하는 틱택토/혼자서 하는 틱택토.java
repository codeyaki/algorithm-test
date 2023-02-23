class Solution {
    int totalSum = 0, count = 9;
    int[] rowSum = new int[3], columnSum = new int[3], diagonalSum = new int[2];

    public int solution(String[] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                int d = 0;
                if (c == 'X') d = -1;
                if (c == 'O') d = 1;
                if (c == '.') {
                    d = 0;
                    count--;
                }
                totalSum += d;
                rowSum[i] += d;
                columnSum[j] += d;
                if (i == j) diagonalSum[0] += d;
                if (i == 2 - j) diagonalSum[1] += d;
            }
        }

        // 순서 오류 ( X가 한개 더많거나, O가 2개더 많거나
        if (totalSum < 0 || totalSum > 1) return 0;
        // O, X 같은 양을 채웠을때 흰돌이 승리한 경우는 올 수 없음
        if (totalSum == 0) {
            // 가로 한줄 완성
            for (int ss : rowSum) {
                if (ss == 3) return 0;
            }
            // 세로 한줄 완성했을 경우
            for (int ss : columnSum) {
                if (ss == 3) return 0;
            }
            // 대각 완성했을 경우
            for (int ss : diagonalSum) {
                if (ss == 3) return 0;
            }
        }
        // 흰돌이 한개 더 뒀을때 검은 돌이 승리한 경우는 올 수 없음
        if (totalSum == 1) {
            // 가로 한줄 완성
            for (int ss : rowSum) {
                if (ss == -3) return 0;
            }
            // 세로 한줄 완성했을 경우
            for (int ss : columnSum) {
                if (ss == -3) return 0;
            }
            // 대각 완성했을 경우
            for (int ss : diagonalSum) {
                if (ss == -3) return 0;
            }
        }
        return 1;
    }

}