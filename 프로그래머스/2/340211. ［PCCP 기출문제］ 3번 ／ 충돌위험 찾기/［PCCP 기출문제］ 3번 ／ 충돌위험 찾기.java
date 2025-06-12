import java.util.*;

class Solution {
    int[][] points;
    int[][] routes; 
    private RobotManger robotManger;
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        points = points;
        routes = routes;
        List<Robot> rList = new LinkedList<>();
        for(int[] route : routes) {
            Robot nr = new Robot();
            nr.now = new int[]{points[route[0] - 1][0], points[route[0] - 1][1]};
            for(int i = 1; i < route.length; i++) {
                nr.route.add(new int[]{points[route[i] - 1][0], points[route[i] - 1][1]});
            }
            rList.add(nr);
        }
        this.robotManger = new RobotManger();
        robotManger.rList = rList;
        answer += robotManger.countDupleRoute();
        // 1초마다 이동하면서 중복있는지 확인
        while(!robotManger.isAllEnd()) {
            answer += robotManger.moveAllandCountCrash();
        }
        return answer;
    }
}
class RobotManger{
    List<Robot> rList = new LinkedList<>();
    
    public boolean isAllEnd() {
        return rList.size() == 0;
    }
    
    public int moveAllandCountCrash() {
        List<Robot> completeRobot = new LinkedList<>();
        for(Robot r : rList) {
            r.move();
            if(r.isEnd()) completeRobot.add(r);
        }
        
        int count = countDupleRoute();
        //System.out.println(this  + ", " + count);
        rList.removeAll(completeRobot);
        return count;
    }
    
    public int countDupleRoute() {
        int[][] countArr = new int[101][101];
        for(Robot r : rList) {
            countArr[r.now[0]][r.now[1]]++;
        }
        int count = 0;
        for(int i = 1; i < 101; i++) {
            for(int j = 1; j < 101; j++) {
                if(countArr[i][j] > 1) count++;
            }
        }
        return count;
    }
    
    public String toString() {
        return "{rList = " + this.rList +"}";
    }
}


class Robot{
    int[] now;
    Queue<int[]> route = new LinkedList<>(); // [r, c]
    
    public boolean isEnd(){
        return route.isEmpty();
    }
    
    public void move() {
        // r부터 이동할 수 있으면 이동하기
        int[] nextPoint = route.peek();
        if(now[0] < nextPoint[0] ) now[0]++;
        else if(now[0] > nextPoint[0]) now[0]--;
        else if(now[1] < nextPoint[1]) now[1]++;
        else if(now[1] > nextPoint[1]) now[1]--;
        // 해당 라우트에 도착하면 다음 라우트로 설정
        if(now[0] == nextPoint[0] && now[1] == nextPoint[1]) route.poll();
    }
    
    public String toString() {
        return "{now=[" + this.now[0] + ", " + this.now[1] + "]}";
    }
}