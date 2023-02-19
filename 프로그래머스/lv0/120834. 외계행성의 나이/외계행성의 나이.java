class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        while(age>0){
            sb.append((char) ('a' + age % 10));
            age /= 10;
        }
        return sb.reverse().toString();
    }
}