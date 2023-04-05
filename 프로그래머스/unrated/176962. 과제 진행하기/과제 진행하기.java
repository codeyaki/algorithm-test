import java.util.*;

class Solution {
    private PriorityQueue<Homework> homeworkQue = new PriorityQueue<>((Comparator.comparingInt(o -> o.initStartTime)));
    private Stack<Homework> restHomework = new Stack<>();
    private String[] answer;

    public String[] solution(String[][] plans) {
        for (int i = 0; i < plans.length; i++) {
            homeworkQue.add(new Homework(plans[i][0], plans[i][1], plans[i][2]));
        }
        answer = new String[plans.length];
        int idx = 0;
        int currentTime = 0;
        while (!homeworkQue.isEmpty()) {
            Homework homework = homeworkQue.poll();
            /* 과제 진행
                1. 과제를 일찍 끝내는 경우 (시간이 남음) + 정시간에 끝내는 경우
                2. 시간안에 과제를 못끝내는 경우
             */
            currentTime = homework.initStartTime;
            // 다음 과제가 없는 경우 inf로 설정
            int nextHomeTime = !homeworkQue.isEmpty() ? homeworkQue.peek().initStartTime : Integer.MAX_VALUE;
            int endTIme = currentTime + homework.playTime;
            if (endTIme > nextHomeTime) {
                // 과제를 시간안에 끝내지 못하는 경우
                homework.doHomework(currentTime, nextHomeTime);
                restHomework.push(homework);
                currentTime = nextHomeTime;
            } else {
                // 과제를 시간안에 끝내는 경우
                answer[idx++] = homework.name;
                currentTime = endTIme;
                // 과제를 하고 남은시간이 있다면 추가 과제 진행
                while (currentTime < nextHomeTime && !restHomework.isEmpty()) {
                    Homework plusHomework = restHomework.pop();
                    int plusEndTime = currentTime + plusHomework.playTime;
                    // 추가 과제를 다못하는 경우
                    if (plusEndTime > nextHomeTime) {
                        plusHomework.doHomework(currentTime, nextHomeTime);
                        restHomework.push(plusHomework);
                        currentTime = nextHomeTime;
                    }
                    // 추가 과제를 다한 경우
                    else {
                        answer[idx++] = plusHomework.name;
                        currentTime = plusEndTime;
                    }
                }
            }


        }
        return this.answer;
    }
    public class Homework{
        String name;
        int initStartTime;
        int playTime;
        public Homework(String name, String initStartTime, String playTime) {
            this.name = name;
            String[] splitStartTime = initStartTime.split(":");
            this.initStartTime = Integer.parseInt(splitStartTime[0]) * 60 + Integer.parseInt(splitStartTime[1]);
            this.playTime = Integer.parseInt(playTime);
        }

        public void doHomework(int startTime, int endTIme) {
            this.playTime -= endTIme - startTime;
        }

        public String toString(){
            return "homew {name = " + this.name + ", initStartTime = " + this.initStartTime + ", playTIme = " + this.playTime + "}";
        }
    }
}