class Solution {
    public int[] solution(String s) {
        int[] cache = new int['z' - 'a' + 1];
        for(int i = 0; i < cache.length; i++){
            cache[i] = -1;
        }
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            answer[i] = cache[s.charAt(i) - 'a'];
            cache[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < answer.length; i++){
            answer[i] = answer[i] == -1 ? -1 : i - answer[i];
        }
        return answer;
    }
}