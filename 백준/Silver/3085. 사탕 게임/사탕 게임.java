import java.io.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static char[][] board; //사탕을 놓을 보드
    private static int n; // 보드 크기
    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        // 부르트 포스, 한개씩 바꿔가며 전부 확인
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, checkRow(i)); // 바꾸기전 행 확인
            max = Math.max(max, checkColumn(i)); // 바꾸기전 열 확인
            // 바꾸기전 캔디가 만약 최대개수를 이미 만족하는 경우 더 돌릴 필요가 없다.
            if (max == n) {
                break;
            }
            for (int j = 0; j < n; j++) {
                // 열 교체
                if (i < n - 1) {
                    swapCandy(i, j, i + 1, j);
                    max = Math.max(max, checkColumn(j));
                    max = Math.max(max, checkRow(i));
                    max = Math.max(max, checkRow(i+1));
                    swapCandy(i, j, i + 1, j);
                }
                // 행 교체
                if (j < n - 1) {
                    swapCandy(i, j, i, j + 1);
                    max = Math.max(max, checkRow(i));
                    max = Math.max(max, checkColumn(j));
                    max = Math.max(max, checkColumn(j+1));
                    swapCandy(i, j, i, j + 1);
                }
            }
        }
        // 출력
        bw.append(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();

    }

    // 캔디 바꾸기
    private static void swapCandy(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    // 행 확인
    private static int checkRow(int row) {
        int max = 1;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (board[row][i] == board[row][i + 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
    // 열 확인
    private static int checkColumn(int column) {
        int max = 1;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (board[i][column] == board[i + 1][column]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}