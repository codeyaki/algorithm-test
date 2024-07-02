import java.util.*;

class Solution {
    private Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        inputScore(info);
        sortByScore();
        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            answer[i] = execQuery(query[i]);
        }
        return answer;
    }
    private void sortByScore() {
        for(String key : map.keySet()) {
            map.get(key).sort((o1, o2) -> o1 - o2);
        }
    }
    
    private int execQuery(String query) {
        String[] split = query.split(" and ");
        String[] soulFoodAndScore = split[3].split(" ");
        int scoreCut = Integer.parseInt(soulFoodAndScore[1]);
        List<Integer> scoreList = map.get(split[0]+split[1]+split[2]+soulFoodAndScore[0]);
        if(scoreList == null) return 0;
        int bs = Collections.binarySearch(scoreList, scoreCut);
        while(bs > 0 && scoreList.get(bs - 1).equals(scoreList.get(bs))) bs--;
        return bs < 0 ? scoreList.size() + bs + 1 : scoreList.size() - bs;
    }
    
    private void inputScore(String[] infos) {
        for(String imfo : infos) {
            String[] split = imfo.split(" ");
            //0 언어, 1포지션, 2레벨, 3소울푸드, 4점수
            // 16가지 경우 전부 넣어주어야함
            int score = Integer.parseInt(split[4]);
            addScore(split[0]+split[1]+split[2]+split[3], score);
            addScore(split[0]+split[1]+split[2]+"-", score);
            addScore(split[0]+split[1]+"-"+split[3], score);
            addScore(split[0]+split[1]+"-"+"-", score);
            addScore(split[0]+"-"+split[2]+split[3], score);
            addScore(split[0]+"-"+split[2]+"-", score);
            addScore(split[0]+"-"+"-"+split[3], score);
            addScore(split[0]+"-"+"-"+"-", score);
            addScore("-"+split[1]+split[2]+split[3], score);
            addScore("-"+split[1]+split[2]+"-", score);
            addScore("-"+split[1]+"-"+split[3], score);
            addScore("-"+split[1]+"-"+"-", score);
            addScore("-"+"-"+split[2]+split[3], score);
            addScore("-"+"-"+split[2]+"-", score);
            addScore("-"+"-"+"-"+split[3], score);
            addScore("-"+"-"+"-"+"-", score);
        }
    }
    void addScore(String key, int score) {
        List<Integer> list = map.get(key);
        if(list == null) {
            list = new ArrayList<>();
        }
        list.add(score);
        map.put(key, list);
    }
}