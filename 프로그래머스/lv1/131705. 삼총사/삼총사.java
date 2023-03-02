class Solution {
    int n, result;
    int[] number;
    boolean[] visited;

    public int solution(int[] number) {
        this.number = number;
        this.n = number.length;
        visited = new boolean[n];
        dfs(0, 0, 0);
        return result;
    }

    void dfs(int now, int sum, int cnt) {
        if (cnt == 3) {
            if(sum == 0) result++;
            return;
        }
        for (int i = now; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i, sum + number[i], cnt + 1);
            visited[i] = false;
        }
    }
}