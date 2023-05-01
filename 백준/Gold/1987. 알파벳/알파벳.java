import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.TransferQueue;

public class Main{
    private static int[][] board;
    private static boolean[] visited;
    private static int r, c, answer;
    private static int[] dx = new int[]{0, 0, -1, 1};
    private static int[] dy = new int[]{-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lineSplit = br.readLine().split(" ");
        r = Integer.parseInt(lineSplit[0]);
        c = Integer.parseInt(lineSplit[1]);
        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }
        br.close();
        visited = new boolean[26]; // 알파벳별 방문 여부
        // 풀이
        visited[board[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int nowX, int nowY, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) {
                continue;
            }
            if(visited[board[nextX][nextY]]) continue;
            visited[board[nextX][nextY]] = true;
            dfs(nextX, nextY, count + 1);
            visited[board[nextX][nextY]] = false;
        }

    }
}