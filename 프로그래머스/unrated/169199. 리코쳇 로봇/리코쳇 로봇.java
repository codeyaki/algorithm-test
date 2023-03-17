import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    boolean[][] visted;
    int[][] map;
    int[] start, goal;
    int n, m;

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        visted = new boolean[n][m];
        // map 생성
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                switch (board[i].charAt(j)) {
                    case 'D':
                        map[i][j] = 1;
                        break; // 장애물
                    case 'G':
                        goal = new int[]{i, j};
                        break; // 도착지점
                    case 'R':
                        start = new int[]{i, j};
                        break; // 로봇
                    default:
                        map[i][j] = 0;
                        break;
                }
            }
        }

        int answer = bfs();
        return answer;
    }

    private int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visted[start[0]][start[1]] = true;
        queue.add(new int[]{start[0], start[1], 0});
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if(point[0] == goal[0] && point[1] == goal[1]) return point[2];
            for (int idx = 0; idx < 4; idx++) {
                int[] next = {point[0], point[1]};
                // 벽을 만나기 전까지 이동
                while (next[0] + dx[idx] >= 0 && next[0] + dx[idx] < n && next[1] + dy[idx] >= 0 && next[1] + dy[idx] < m) {
                    // 장애물을 만나는 경우 스탑
                    if (map[next[0] + dx[idx]][next[1] + dy[idx]] == 1) {
                        break;
                    }
                    next = new int[]{next[0] + dx[idx], next[1] + dy[idx], point[2] + 1};
                }
                if(visted[next[0]][next[1]]) continue;
                visted[next[0]][next[1]] = true;
                queue.add(next);
            }
        }
        return -1;
    }
}