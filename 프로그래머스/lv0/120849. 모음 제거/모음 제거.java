class Solution {
    public String solution(String my_string) {
        my_string = my_string.replaceAll("[a,e,i,o,u]", "");
        return my_string;
    }
}