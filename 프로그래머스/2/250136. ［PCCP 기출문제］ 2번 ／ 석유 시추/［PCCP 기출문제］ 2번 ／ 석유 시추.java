import java.util.*;

class Solution {
    private Map<Integer, Integer> countMap = new HashMap<>();
    private int mark = 2;
    private int[][] land;
    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        this.land = land;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(land[i][j] == 0) continue; // 석유 아닌 공간, 이미 체크한 공간 제외
                if(land[i][j] > 1) continue; // 이미 구한 공간
                countMap.put(mark, markLand(mark, i, j, n, m));
                mark++;
            }
        }
        
        
        for(int j = 0; j < m; j++) {
            boolean[] checked = new boolean[mark + 1]; // 중복 제거용
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int nowMark = land[i][j];
                if(nowMark < 2) continue;
                if(checked[nowMark]) continue;
                checked[nowMark] = true;
                sum += countMap.get(nowMark);
            }
            answer = Math.max(answer, sum);
            
        }
        return answer;
    }
    private int markLand(int mark, int startX, int startY, int n, int m){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startX, startY});
        land[startX][startY] = mark;
        int count = 1;
        while(!que.isEmpty()) {
            int[] now = que.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(land[nextX][nextY] != 1) continue;
                land[nextX][nextY] = mark;
                count++;
                que.add(new int[]{nextX, nextY});
            }
        }
        return count;
    }
    
    private void print(int n, int m) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(land[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println(countMap);
    }
}