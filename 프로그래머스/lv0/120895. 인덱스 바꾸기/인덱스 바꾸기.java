class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuffer sb = new StringBuffer();
        sb.append(my_string.substring(0, num1));
        sb.append(my_string.charAt(num2));
        sb.append(my_string.substring(num1 + 1, num2));
        sb.append(my_string.charAt(num1));
        sb.append(my_string.substring(num2 + 1));
        return sb.toString();
    }
}