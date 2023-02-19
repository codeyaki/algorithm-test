class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        int length = my_string.length();
        for(int i =0; i<length; i++){
            sb.append(my_string.charAt(length - i - 1));
        }
        return sb.toString();
    }
}