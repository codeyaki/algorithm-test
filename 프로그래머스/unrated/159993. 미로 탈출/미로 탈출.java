import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int n, m;
    int[] start, exit, lever, dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    int[][] distanceFromLever;
    boolean[][] wall;

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        wall = new boolean[n][m];
        distanceFromLever = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char block = maps[i].charAt(j);
                wall[i][j] = block == 'X' ? true : false;
                if (block == 'S') start = new int[]{i, j};
                if (block == 'E') exit = new int[]{i, j};
                if (block == 'L') lever = new int[]{i, j};
            }
        }
        bfs(lever);
        int distanceStartToLever = distanceFromLever[start[0]][start[1]];
        int distanceLeverToExit = distanceFromLever[exit[0]][exit[1]];

        if (distanceStartToLever == 0 || distanceLeverToExit == 0) {
            return -1;
        }

        return distanceStartToLever + distanceLeverToExit;
    }

    private int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        // x, y, 거리
        int[] root = {start[0], start[1]};
        queue.add(root);
        boolean[][] visited = new boolean[n][m];
        visited[root[0]][root[1]] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            // goal이 아닌 경 동서남북 이동
            for (int i = 0; i < 4; i++) {
                int[] next = {now[0] + dx[i], now[1] + dy[i]};
                // 맵을 벗어나는 경우
                if (next[0] < 0 || next[1] < 0 || next[0] >= n || next[1] >= m) continue;

                // 이미 방문했거나 벽인 경우
                if(wall[next[0]][next[1]] || visited[next[0]][next[1]]) continue;

                // 둘 다 아닌 경우 탐험
                distanceFromLever[next[0]][next[1]] = distanceFromLever[now[0]][now[1]] + 1;
                visited[next[0]][next[1]] = true;
                queue.add(next);
            }
        }
        return -1;
    }

}