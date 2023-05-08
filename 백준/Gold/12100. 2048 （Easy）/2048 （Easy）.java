import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, answer = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(board, 1);
        System.out.println(answer);
    }

    private static void dfs(int[][] board, int count) {
        if (count > 5) {
            return;
        }

        // 동, 서, 남, 북 밀기
        int[][] eastBoard = new int[n][n];
        int[][] westBoard = new int[n][n];
        int[][] southBoard = new int[n][n];
        int[][] northBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queEast = new LinkedList<>();
            Queue<Integer> queWest = new LinkedList<>();
            Queue<Integer> queSouth = new LinkedList<>();
            Queue<Integer> queNorth = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if(board[i][j] != 0) queEast.add(board[i][j]);
                if(board[i][n - j - 1] != 0) queWest.add(board[i][n - j - 1]);
                if(board[j][i] != 0) queSouth.add(board[j][i]);
                if(board[n - j - 1][i] != 0) queNorth.add(board[n - j - 1][i]);
            }
            queEast = merge(queEast);
            queWest = merge(queWest);
            queSouth = merge(queSouth);
            queNorth = merge(queNorth);
            // 동
            int idx = 0;
            while(!queEast.isEmpty()){
                eastBoard[i][idx++] = queEast.poll();
            }
            // 서
            idx = n - 1;
            while(!queWest.isEmpty()){
                westBoard[i][idx--] = queWest.poll();
            }
            // 남
            idx = 0;
            while(!queSouth.isEmpty()){
                southBoard[idx++][i] = queSouth.poll();
            }
            // 북
            idx = n - 1;
            while(!queNorth.isEmpty()){
                northBoard[idx--][i] = queNorth.poll();
            }
        }
        // 새로 만들어진 board로 재 탐색
        dfs(eastBoard, count + 1);
        dfs(westBoard, count + 1);
        dfs(southBoard, count + 1);
        dfs(northBoard, count + 1);
    }

    private static Queue<Integer> merge(Queue<Integer> que) {
        Queue<Integer> result = new LinkedList<>();
        while (!que.isEmpty()) {
            Integer now = que.poll();
            // 만약 같은 숫자라면 겹치기
            if (now.equals(que.peek())) {
                now += que.poll();
            }
            // 가장 높은 값 찾아내기
            answer = Math.max(now, answer);
            result.add(now);
        }
        return result;
    }
}