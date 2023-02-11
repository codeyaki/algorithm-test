class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            answer += findInBabbling(babbling[i]);
        }
        return answer;
    }

    public int findInBabbling(String babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < 4; i++) {
            if (babbling.contains(words[i])) {
                babbling = babbling.replace(words[i], " ");
            }
        }
        for (int i = 0; i < babbling.length(); i++) {
            if (babbling.charAt(i) != ' ') {
                return 0;
            }
        }
        return 1;
    }
}