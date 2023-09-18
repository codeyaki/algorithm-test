import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        String lastWord = words[0];
        set.add(words[0]);
        for(int i = 1; i < words.length; i++){
            if(set.contains(words[i])){
                // 이미 말했던 단어일 경우
                return new int[]{i % n + 1, i / n + 1};
            }
            else if(lastWord.charAt(lastWord.length() - 1) != words[i].charAt(0)){
                return new int[]{i % n + 1, i / n + 1};
            }
            lastWord = words[i];
            set.add(words[i]);
        }
        return new int[]{0, 0};
    }
}