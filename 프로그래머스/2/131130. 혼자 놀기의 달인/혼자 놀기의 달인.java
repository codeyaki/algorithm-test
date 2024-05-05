import java.util.*;

class Solution {
    private int[] flags;
    public int solution(int[] cards) {
        int n = cards.length;
        flags = new int[n];
        List<Integer> flagsCount = new LinkedList<>();
        int flag = 1;
        for(int i = 0; i < n; i++) {
            if(flags[i] == 0) flagsCount.add(bfs(i, cards, flag++));
        }
        if(flagsCount.size() < 2) return 0;
        flagsCount.sort((o1, o2) -> o2 - o1);
        return flagsCount.get(0) * flagsCount.get(1);
    }
    
    private int bfs(int startIndex, int[] cards, int flag) {
        Queue<Integer> que = new LinkedList<>();
        que.add(startIndex);
        int result = 0;
        while(!que.isEmpty()) {
            int cardIndex = que.poll();
            flags[cardIndex] = flag;
            int card = cards[cardIndex] - 1;
            result++;
            if(flags[card] == flag) return result; // 이미 개봉한 상자인 경우 중단
            que.add(card);
        }
        return result;
    }
}