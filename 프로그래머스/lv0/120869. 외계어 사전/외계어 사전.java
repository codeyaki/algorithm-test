class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        loop:
        for(String d : dic){
            for(String p : spell){
                if(!d.contains(p)) continue loop;
            }
            return 1;
        }
        return 2;
    }
}