import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] board;
    private static int n, m;
    private static int[] dx = new int[]{0, 0, -1, 1};
    private static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l = br.readLine().split(" ");
        n = Integer.parseInt(l[0]);
        m = Integer.parseInt(l[1]);
        board = new int[n][m];
        int[] startRed = new int[2];
        int[] startBlue = new int[2];
        int[] goal = new int[2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char place = line.charAt(j);
                int itemNo = 0;
                if (place == '#') {
                    itemNo = 2; // 벽
                } else if (place == 'O') {
                    itemNo = 1; // 구멍
                } else if (place == 'R') {
                    startRed = new int[]{i, j};
                } else if (place == 'B') {
                    startBlue = new int[]{i, j};
                }
                board[i][j] = itemNo;
            }
        }
        // 풀이
        // 동서남북으로 기울이는 모든 경우의 수 bfs
        int answer = bfs(startRed, startBlue);
        System.out.println(answer);

    }

    private static int bfs(int[] startRed, int[] startBlue) {
        Queue<Position> que = new LinkedList<>();
        // 초기 위치
        que.add(new Position(startRed[0], startRed[1], startBlue[0], startBlue[1], 0));
        boolean[][][][] visited = new boolean[n][m][n][m]; // red + blue 포지션

        while (!que.isEmpty()) {
            Position now = que.poll();
            // 빨강공이 들어가는 경우
            if (board[now.redX][now.redY] == 1) {
                return now.count;
            }
            // 현재 10번인 경우 다음이동을 할 수 없음
            if (now.count >= 10 ) continue;

            // 동서남북 추가하기
            for (int direction = 0; direction < 4; direction++) {
                int[] movedRed = move(now.redX, now.redY, direction);
                int[] movedBlue = move(now.blueX, now.blueY, direction);
                // 파란색이 구멍에 들어가면 실패
                if (board[movedBlue[0]][movedBlue[1]] == 1) continue;
                if (movedRed[0] == movedBlue[0] && movedRed[1] == movedBlue[1]) {
                    // 둘다 구멍이 빠진 것이 아닌 경우 더 많이 움직인것을 한칸 뒤로
                    if (movedRed[2] > movedBlue[2]) {
                        unMove(movedRed, direction);
                    } else if (movedRed[2] < movedBlue[2]) {
                        unMove(movedBlue, direction);
                    }
                }
                // 만약 이미 방문했던 지점이라면 skip
                if (visited[movedRed[0]][movedRed[1]][movedBlue[0]][movedBlue[1]]) continue;
                visited[movedRed[0]][movedRed[1]][movedBlue[0]][movedBlue[1]] = true;
                que.add(new Position(movedRed[0], movedRed[1], movedBlue[0], movedBlue[1], now.count + 1));
            }
        }
        return -1;
    }

    private static int[] unMove(int[] ballPosition, int direction) {
        // i는 왔던 방향
        ballPosition[0] = ballPosition[0] + (dx[direction] * -1);
        ballPosition[1] = ballPosition[1] + (dy[direction] * -1);
        return ballPosition;
    }

    private static int[] move(int x, int y, int direction) {
        int count = 0;
        while (x >= 0 && y >= 0 && x < n && y < m) {
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];
            count++;
            if (board[nextX][nextY] == 2) {
                // 옮겼을때 만약 벽인 경우
                break;
            } else if (board[nextX][nextY] == 1) {
                // 만약 구멍인 경우
                x = nextX;
                y = nextY;
                break;
            } else {
                x = nextX;
                y = nextY;
            }
        }
        return new int[]{x, y, count};
    }
}

class Position {
    int redX, redY, blueX, blueY, count;

    public Position(int redX, int redY, int blueX, int blueY, int count) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.count = count;
    }
}