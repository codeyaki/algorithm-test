class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            answer[i] = minDistance(m, n, startX, startY, balls[i][0], balls[i][1]);
        }
        return answer;
    }

    public int minDistance(int m, int n, int startX, int startY, int goalX, int goalY) {
        int result = Integer.MAX_VALUE;
        if (!(startX == goalX && startY < goalY) ) {
            result = Math.min(result, calDistance(startX, startY, goalX, (n - goalY) + n));
        }
        if (!(startX == goalX && startY > goalY)){
            result = Math.min(result, calDistance(startX, startY, goalX, -goalY));
        }
        if (!(startY == goalY && startX < goalX)) {
            result = Math.min(result, calDistance(startX, startY, (m - goalX) + m, goalY));
        }
        if(!(startY == goalY && startX > goalX)){
            result = Math.min(result, calDistance(startX, startY, -goalX, goalY));
        }
        if (startX / startY == 1) {
            result = Math.min(result, calDistance(startX, startY, (m - goalX) + m, (n - goalY) + n));
            result = Math.min(result, calDistance(startX, startY, (m - goalX) + m, -goalY));
            result = Math.min(result, calDistance(startX, startY, -goalX, (n - goalY) + n));
            result = Math.min(result, calDistance(startX, startY, -goalX, -goalY));
        }

        return result;
    }

    public int calDistance(int startX, int startY, int endX, int endY) {
        return (int) (Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
    }
}