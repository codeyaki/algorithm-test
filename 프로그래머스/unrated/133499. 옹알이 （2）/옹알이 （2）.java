class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canWord = new String[]{"aya", "ye", "woo", "ma"};
        // 한개 단어씩 확인
        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j < 4; j++){
                babbling[i] = babbling[i].replaceAll(canWord[j], "-");
                // 만약 연속된 발음이 있는 경우
                if(babbling[i].contains("--")) continue;
                babbling[i] = babbling[i].replaceAll("-", "_");
            }
            // 정리
            while(babbling[i].contains("__"))
            babbling[i] = babbling[i].replaceAll("__", "_");
        }
        for(String b : babbling){
            if(b.equals("_")) answer++;
        }
        return answer;
    }
}