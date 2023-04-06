import java.util.*;

class Solution {
    String[] rankArr;
    Map<String, Integer> playerMap = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        rankArr = players;
        for(int i = 0; i < players.length; i++){
            playerMap.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++){
            String calledPlayer = callings[i];
            int rank = playerMap.get(calledPlayer);
            over(rank);
        }
        return players;        
    }
    private void over(int rank){
        String tmp = rankArr[rank];
        rankArr[rank] = rankArr[rank-1];
        rankArr[rank-1] = tmp;
        playerMap.put(tmp, rank - 1);
        playerMap.put(rankArr[rank], rank);
    }
}