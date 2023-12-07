class Solution {
    private int removeZero = 0;
    private int round = 0;
    public int[] solution(String s) {
        while(!"1".equals(s)){
            round++;
            s = convert(s);
        }
        return new int[]{round, removeZero};
    }
    private String convert(String s) {
        String result = s.replaceAll("0", "");
        removeZero += s.length() - result.length();
        return Integer.toBinaryString(result.length());
    }
}