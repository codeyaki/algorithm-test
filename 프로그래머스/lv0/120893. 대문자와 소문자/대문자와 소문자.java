class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if (Character.isUpperCase(c)){
                c = Character.toLowerCase(c);
            } else{
                c = Character.toUpperCase(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}