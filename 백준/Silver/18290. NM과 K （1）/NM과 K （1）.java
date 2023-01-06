import java.io.*;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int m;
    private static int k;
    private static int[][] map;
    private static int maxSum = Integer.MIN_VALUE;
    private static List<Pair> selectPointList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // dfs 돌리기
        dfs(0, 0, 0);
        // 출력
        bw.append(String.valueOf(maxSum));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, int count) {
        // 블록선택개수(count)가 k개 이상인 경우 합이 최대 값인지 확인
        if (count >= k) {
            int sum = 0;
            for (Pair pair : selectPointList) {
                sum += pair.getValue();
            }
            maxSum = maxSum < sum ? sum : maxSum;
            return;
        }

        // 모든 점을 돌면서 확인하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 불가능 하다면 넘기기
                if (!checkSelectedPoint(i, j)) {
                    continue;
                }
                selectPointList.add(new Pair(i, j));
                dfs(i, j, count + 1);
                selectPointList.remove(count);

            }

        }

    }

    private static boolean checkSelectedPoint(int i, int j) {
        // 선택한 모든 점을 돌며 가능한지 확인
        for (Pair pair : selectPointList) {
            // 해당 점
            if (i == pair.x && j == pair.y) {
                return false;
            }
            // 상
            if (i == pair.x + 1 && j == pair.y) {
                return false;
            }
            // 하
            if (i == pair.x - 1 && j == pair.y) {
                return false;
            }
            // 좌
            if (i == pair.x && j == pair.y - 1) {
                return false;
            }
            // 우
            if (i == pair.x && j == pair.y + 1) {
                return false;
            }
        }
        return true;

    }

    static class Pair{
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getValue() {
            return map[this.x][this.y];
        }
    }
}