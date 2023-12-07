class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String strNum : s.split(" ")){
            int num = Integer.parseInt(strNum);
            max = Math.max(max, num);
            min = Math.min(min, num);
            
        }
        String answer = min + " " + max;
        return answer;
    }
}