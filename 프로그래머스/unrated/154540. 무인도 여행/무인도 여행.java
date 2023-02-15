import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<Integer> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[][] visited;
    int[][] foodMap;
    int n, m, food;
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        foodMap = new int[n][m];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < m; j++) {
                foodMap[i][j] = maps[i].charAt(j) == 'X' ? -1 : Character.getNumericValue(maps[i].charAt(j));
                if(foodMap[i][j] == -1) visited[i][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]) continue;
                visited[i][j] = true;
                food = 0;
                dfs(i, j);
                result.add(food);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);
        return answer.length == 0 ? new int[]{-1} : answer ;
    }

    private void dfs(int i, int j) {
        food += foodMap[i][j];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int index = 0; index < 4; index++) {
            int nextX = i + dx[index];
            int nextY = j + dy[index];
            if (nextX < 0 || nextY < 0 || nextY > m - 1 || nextX > n - 1) {
                continue;
            }
            if (visited[nextX][nextY]) continue;
            visited[nextX][nextY] = true;
            dfs(nextX, nextY);
        }
    }


}