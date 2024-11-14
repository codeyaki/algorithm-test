class Solution {
    public String[] solution(String my_string) {
        while(my_string.contains("  ")) my_string = my_string.replace("  ", " ");
        String[] answer = my_string.trim().split(" ");
        return answer;
    }
}