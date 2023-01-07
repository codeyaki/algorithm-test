import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int m;
    private static int k;
    private static int[][] map;
    private static int maxSum = Integer.MIN_VALUE;
    private static boolean[][] visitedPoint;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visitedPoint = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // dfs 돌리기
        dfs(0, 0, 0, 0);
        // 출력
        bw.append(String.valueOf(maxSum));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, int count, int sum) {
        // 블록선택개수(count)가 k개 이상인 경우 합이 최대 값인지 확인
        if (count >= k) {
            maxSum = maxSum < sum ? sum : maxSum;
            return;
        }

        // 모든 점을 돌면서 확인하기
        for (int i = x; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 확인할 좌표
                // 불가능 하다면 넘기기
                if (!checkSelectedPoint(i, j)) {
                    continue;
                }
                visitedPoint[i][j] = true;
                dfs(i, j, count + 1, sum + map[i][j]);
                visitedPoint[i][j] = false;
            }
        }

    }

    private static boolean checkSelectedPoint(int x, int y) {
        // 해당 점의 상하좌우의 점이 이미 방문한 점이면 방문할수 없다.
        int dx[] = new int[]{0, 1, -1, 0, 0};
        int dy[] = new int[]{0, 0, 0, 1, -1};
        for (int i = 0; i < 5; i++) {
            int movedX = x + dx[i];
            int movedY = y + dy[i];
            if (movedX >= 0  // 아래로 이동했을때 음수면 이동할 필요가 없음
                    && movedX < n // 위로 이동했을때 n 이상이면 이동할 필요가 없음
                    && movedY >= 0 // 왼쪽으로 이동했을때 음수면 이동할 필요가 없음
                    && movedY < m // 오른쪽으로 이동했을때 m 이상이면 이동할 필요가 없음
                    && visitedPoint[movedX][movedY]
            ) {
                return false;
            }
        }
        // 방문했던 점이 아니라면
        return true;
    }

}
