import java.util.*;

class Solution {
    public String solution(String s) {
        Map<Character, Integer> cntStrMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer cntC = cntStrMap.getOrDefault(c, 0);
            cntStrMap.put(c, ++cntC);
        }
        Set<Character> keySet = cntStrMap.keySet();
        List<Character> notDuplicatedList = new ArrayList<>();
        for (char key : keySet) {
            if(cntStrMap.get(key) == 1) notDuplicatedList.add(key);
        }
        Collections.sort(notDuplicatedList);
        StringBuilder answer = new StringBuilder();
        for (char c : notDuplicatedList) {
            answer.append(c);
        }
        return answer.toString();
    }
}