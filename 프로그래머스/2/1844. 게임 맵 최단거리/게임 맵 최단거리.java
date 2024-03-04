import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(0, 0, maps);
    }
    
    private int bfs(int startX, int startY, int[][] maps){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startX, startY));
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int goalX = maps.length - 1;
        int goalY = maps[0].length - 1;
        
        while(!que.isEmpty()){
            Node now = que.poll();
            if(now.x == goalX && now.y == goalY) return now.round;
            for(int i = 0; i < 4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                // 맵의 범위를 넘는 경우
                if(nextX < 0 || nextX > goalX || nextY < 0 || nextY > goalY) continue;
                // 이미 방문했거나 벽인 경우
                if(maps[nextX][nextY] == 0) continue;
                maps[nextX][nextY] = 0;
                que.add(new Node(nextX, nextY, now.round + 1));
            }
        }
        return -1;
    }
    
    class Node{
        private int x;
        private int y;
        private int round;
        
        Node(int x, int y){
            this(x, y, 1);
        }
        Node(int x, int y, int round){
            this.x = x;
            this.y = y;
            this.round = round;
        }
    }
}