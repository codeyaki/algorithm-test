import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 방벽 3개 배치하기 (BFS)
 * 2. 바이러스 시뮬레이션 하기 (DFS)
 * 3. 바이러스가 퍼진뒤에 안전지대 개수 구하기.
 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int m,n, result;
    static int[][] map, wall, virus;
    static int[] dx = {0, 0, 1, -1},
                 dy = {1, -1, 0, 0};
    static List<Point> virusPoint = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        wall = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if (input == 1) {
                    wall[i][j] = 1;
                }
                if (input == 2) {
                    virusPoint.add(new Point(i, j));
                }
            }
        }
        // 1. 방벽 배치
        putWall(0);

        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();


    }

    private static void putWall(int count) {
        if (count == 3) {
            // 2. 바이러스 시뮬레이션
            virus = new int[n][m];
            for (Point point : virusPoint) {
                virus[point.getX()][point.getY()] = 2;
                virusSimulation(point.getX(), point.getY());
            }

            // 3. 안전구역 개수 계산
            int safeZone = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (wall[i][j] == 1 || virus[i][j] == 2) continue;
                    safeZone++;
                }
            }
            result = Math.max(result, safeZone);
            return;
        }
        // 벽을 한개씩 둬보기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2 || wall[i][j] == 1) continue;
                wall[i][j] = 1;
                putWall(count + 1);
                wall[i][j] = 0;
            }
        }


    }

    private static void virusSimulation(int pointX, int pointY) {
        for (int i = 0; i < 4; i++) {
            int movedX = pointX + dx[i];
            int movedY = pointY + dy[i];
            // 범위 밖은 넘어가기
            if (movedX < 0 || movedX >= n || movedY < 0 || movedY >= m) continue;
            // 이미 벽이나 바이러스인 경우 넘어가기
            if (wall[movedX][movedY] == 1 || virus[movedX][movedY] == 2) continue;
            virus[movedX][movedY] = 2;
            virusSimulation(movedX, movedY);
        }
    }

    static class Point {
        private int x;
        private int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}