import java.util.*;

class Solution {
    private int[] currentXY = {5, 5};
    private boolean[][][][] visited = visited = new boolean[11][11][11][11];
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private Map<Character, Integer> directionIndexMap = new HashMap<>(){{
        put('U', 0);
        put('D', 1);
        put('L', 2);
        put('R', 3);
    }};
    
        
    public int solution(String dirs) {
        int answer = 0;
        for(int i = 0; i < dirs.length(); i++){
            char nowDirection = dirs.charAt(i);
            int nowDirectionIndex = directionIndexMap.get(nowDirection);
            int[] nextXY = {currentXY[0] + dx[nowDirectionIndex], currentXY[1] + dy[nowDirectionIndex]};
            
            // 이동 후 좌표 넘어가는 경우
            if(nextXY[0] < 0 || nextXY[1] < 0 || nextXY[0] > 10 || nextXY[1] > 10) continue;
            
            // 처음 보는 길인 경우 + 1
            if(!visited[currentXY[0]][currentXY[1]][nextXY[0]][nextXY[1]]) answer++;
            
            visited[currentXY[0]][currentXY[1]][nextXY[0]][nextXY[1]] = true;
            visited[nextXY[0]][nextXY[1]][currentXY[0]][currentXY[1]] = true;
            
            currentXY = nextXY;
        }
        
        return answer;
    }
}