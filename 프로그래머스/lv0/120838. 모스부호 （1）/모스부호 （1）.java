import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    Map<String, Character> morse = new HashMap<>();

    public Solution() {
        morse.putAll(Map.of(".-", 'a', "-...", 'b', "-.-.", 'c'));
        morse.putAll(Map.of("-..", 'd', ".", 'e', "..-.", 'f'));
        morse.putAll(Map.of("--.", 'g', "....", 'h', "..", 'i'));
        morse.putAll(Map.of(".---", 'j', "-.-", 'k', ".-..", 'l'));
        morse.putAll(Map.of("--", 'm', "-.", 'n', "---", 'o'));
        morse.putAll(Map.of(".--.", 'p', "--.-", 'q', ".-.", 'r'));
        morse.putAll(Map.of("...", 's', "-", 't', "..-", 'u'));
        morse.putAll(Map.of("...-", 'v', ".--", 'w', "-..-", 'x'));
        morse.putAll(Map.of("-.--", 'y', "--..", 'z'));
    }

    public String solution(String letter) {
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(letter, " ");
        while (st.hasMoreTokens()) {
            answer.append(morse.get(st.nextToken()));
        }
        return answer.toString();
    }


}