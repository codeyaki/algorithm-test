import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // bfs 방법으로 찾기
        Map<String, Boolean> vistedWordsMap = new HashMap<>();
        for(String word : words) {
            vistedWordsMap.put(word, false);
        }
        Queue<QueWord> que = new LinkedList<>();
        que.add(new QueWord(begin, 0));
        while(!que.isEmpty()){
            QueWord now = que.poll();
            for(String nextWord : words) {
                if(vistedWordsMap.get(nextWord)) continue;
                if(!isDiffrentOneCharter(now.word, nextWord)) continue;
                // 만약 다음 워드가 정답인 경우
                if(nextWord.equals(target)) return now.count + 1;
                vistedWordsMap.put(nextWord, true);
                que.add(new QueWord(nextWord, now.count + 1));
            }
        }
        return 0;
    }
    
    private class QueWord{
        String word;
        int count;
        
        QueWord(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    
    private boolean isDiffrentOneCharter(String word1, String word2){
        int count = 0;
        for (int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
            }
        }
        if(count == 1) return true;
        return false;
    }
}