class Solution {
    public String solution(int q, int r, String code) {
        int n = code.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i * q + r < n; i++){
            sb.append(code.charAt(i * q + r));
        }
        return sb.toString();
    }
}