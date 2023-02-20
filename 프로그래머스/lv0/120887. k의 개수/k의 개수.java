class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int num = i; num <= j; num++){
            String stringNum = String.valueOf(num);
            String afterNum = stringNum.replaceAll(String.valueOf(k), "");
            answer += stringNum.length() - afterNum.length();
        }
        return answer;
    }
}