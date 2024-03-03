import java.util.*;
class Solution {
    private String[] alphabet = new String[]{"A", "E", "I", "O", "U"};
    private List<String> dic = new ArrayList<>();
    
    public Solution() {
        for(int i = 0; i < 5; i++){
            makeDictionary(i, alphabet[i], 1);
        }
    }
    
    public int solution(String word) {
        return dic.indexOf(word) + 1;
    }
    
    private void makeDictionary(int nowIndex, String now, int length) {
        if (length > 5) return;
        if (!dic.contains(now)) dic.add(now);
        for(int i = 0; i < 5; i++){
            makeDictionary(i, now + alphabet[i], length + 1);
        }   
    }
}