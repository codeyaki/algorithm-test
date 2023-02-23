import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 키 별로 가장 빠른 순서 찾기
        int[] howClick = new int['Z' - 'A' + 1];
        Arrays.fill(howClick, Integer.MAX_VALUE);
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                int keyIndex = keymap[i].charAt(j) - 'A';
                howClick[keyIndex] = Math.min(j + 1, howClick[keyIndex]);
            }
        }
        // 키 얼만큼 눌러야하는지 계산 (0인경우 구할 수 없음)
        int[] answer = new int[targets.length];
         loop:
         for (int i = 0; i < answer.length; i++) {
             for (int j = 0; j < targets[i].length(); j++) {
                 int click = howClick[targets[i].charAt(j) - 'A'];
                 if(click == Integer.MAX_VALUE) {
                     answer[i] = -1;
                     continue loop;
                 }
                 answer[i] += click;
             }
         }
        return answer;
    }
}