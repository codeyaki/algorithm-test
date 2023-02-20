class Solution {
    public int solution(int i, int j, int k) {
        String str = "";
        for(int a = i; a <= j; a++) {
            str += a+"";
        }

        return str.length() - str.replace(k+"", "").length();
    }
}