import java.io.*;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 종이의 세로 크기
    private static int n;
    // 종이의 가로 크기
    private static int m;
    // 종이 배열
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        input();
        int result = solution();
        output(result);

    }

    /**
     * 입력
     * 첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
     * 둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다.
     * i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다.
     * 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
     */
    private static void input() throws IOException {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::parseInt).toArray();
        }
    }

    /**
     * 출력
     * @param result 합의 최댓값
     * 첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.
     */
    private static void output(int result) throws IOException {
        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 풀이 알고리즘 로직
     * 2가지의 I, 4가지의 J, 4가지의 L, 1가지의 O, 2가지의 S, 4가지의 T, 2가지의 Z를 전부 확인해야 한다.
     * @return 가장 높은 합
     */
    private static int solution() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, checkI(i, j));
                result = Math.max(result, checkJ(i, j));
                result = Math.max(result, checkL(i, j));
                result = Math.max(result, checkO(i, j));
                result = Math.max(result, checkS(i, j));
                result = Math.max(result, checkT(i, j));
                result = Math.max(result, checkZ(i, j));
            }

        }
        return result;
    }



    // I모양 체크 (2가지)
    private static int checkI(int i, int j) {
        int result = 0;
        // □
        // □
        // □
        // □
        if (i < n - 3) {
            int sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];
            result = Math.max(result, sum);
        }
        // □ □ □ □
        if (j < m - 3) {
            int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
            result = Math.max(result, sum);
        }

        return result;
    }

    //J모양 체크(4가지)
    private static int checkJ(int i, int j) {
        int result = 0;
        //   □
        //   □
        // □ □
        if (i < n - 2 && j < m - 1) {
            int sum = paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1] + paper[i + 2][j];
            result = Math.max(result, sum);

        }
        // □
        // □ □ □
        if (i < n - 1 && j < m - 2) {
            int sum = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
            result = Math.max(result, sum);
        }
        // □ □
        // □
        // □
        if (i < n - 2 && j < m - 1) {
            int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 2][j];
            result = Math.max(result, sum);
        }
        // □ □ □
        //     □
        if (i < n - 1 && j < m - 2) {
            int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 2];
            result = Math.max(result, sum);
        }
        return result;
    }

    // L모양 체크(4가지)
    private static int checkL(int i, int j) {
        int result = 0;
        // □
        // □
        // □ □
        if (i < n - 2 && j < m - 1) {
            int sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
            result = Math.max(result, sum);
        }
        // □ □ □
        // □
        if (i < n - 1 && j < m - 2) {
            int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j];
            result = Math.max(result, sum);
        }
        // □ □
        //   □
        //   □
        if (i < n - 2 && j < m - 1) {
            int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
            result = Math.max(result, sum);
        }
        //     □
        // □ □ □
        if (i < n - 1 && j < m - 2) {
            int sum = paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2] + paper[i][j + 2];
            result = Math.max(result, sum);
        }

        return result;
    }

    // O 체크 (1가지)
    private static int checkO(int i, int j) {
        int result = 0;
        // □ □
        // □ □
        if (i < n - 1 && j < m - 1) {
            int sum = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1];
            result = Math.max(result, sum);
        }
        return result;
    }

    // S체크 (2가지)
    private static int checkS(int i, int j) {
        int result = 0;
        //   □ □
        // □ □
        if (i < n - 1 && j < m - 2) {
            int sum = paper[i + 1][j] + paper[i + 1][j + 1] + paper[i][j + 1] + paper[i][j + 2];
            result = Math.max(result, sum);
        }
        // □
        // □ □
        //   □
        if (i < n - 2 && j < m - 1) {
            int sum = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
            result = Math.max(result, sum);
        }
        return result;
    }


    // T체크 (4가지)
    private static int checkT(int i, int j) {
        int result = 0;
        // □ □ □
        //   □
        if (i < n - 1 && j < m - 2) {
            int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 1];
            result = Math.max(result, sum);
        }
        //   □
        // □ □
        //   □
        if (i < n - 2 && j < m - 1) {
            int sum = paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
            result = Math.max(result, sum);
        }
        //   □
        // □ □ □
        if (i < n - 1 && j < m - 2) {
            int sum = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
            result = Math.max(result, sum);
        }
        // □
        // □ □
        // □
        if (i < n - 2 && j < m - 1) {
            int sum = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j];
            result = Math.max(result, sum);
        }
        return result;
    }

    // Z체크 (2가지)
    private static int checkZ(int i, int j) {
        int result = 0;
        // □ □
        //   □ □
        if (i < n - 1 && j < m - 2) {
            int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
            result = Math.max(result, sum);
        }
        //   □
        // □ □
        // □
        if (i < n - 2 && j < m - 1) {
            int sum = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j];
            result = Math.max(result, sum);
        }
        return result;
    }
}
