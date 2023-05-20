import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < testCase; t++){
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);
            boolean[][] field = new boolean[n][m];
            for(int i = 0; i < k; i++){
                line = br.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                field[x][y] = true;
            }
            Solution solution = new Solution(n, m, field);
            sb.append(solution.getAnswer()).append("\n");
        }
        System.out.println(sb);
    }
}

class Solution {
    int result = 0, n, m;
    boolean[][] field;

    final int[] dx = {0, 0, 1, -1};
    final int[] dy = {-1, 1, 0, 0};
    
    public Solution(int n, int m, boolean[][] field){
        this.n = n;
        this.m = m;
        this.field = field;
    }

    public int getAnswer(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!field[i][j]) continue;
                result++;
                field[i][j] = false;
                bfs(i, j);
            }
        }
        return this.result;
    }

    private void bfs(int startX, int startY){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startX, startY});
        while(!que.isEmpty()){
            int[] now = que.poll();
            for(int i = 0; i < 4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(!field[nextX][nextY]) continue;
                field[nextX][nextY] = false;
                que.add(new int[]{nextX, nextY});
            }
        }
    }
}
