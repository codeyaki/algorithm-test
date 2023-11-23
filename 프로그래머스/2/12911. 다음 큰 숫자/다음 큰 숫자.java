class Solution {
    public int solution(int n) {
        String binaryString = Integer.toBinaryString(n);
        int lastOneIndex = binaryString.lastIndexOf("1");

        int count = -1;

        for(int i = lastOneIndex; i >= 0; i--) {
            if(binaryString.charAt(i) == '1') count++;
            else break;
        }
        String sumBinary = binaryString.substring(lastOneIndex);
        String sumRest = count > 0 ? "1".repeat(count) : "0";
        int answer =  n + Integer.parseInt(sumBinary, 2) + Integer.parseInt(sumRest, 2);
        return answer;
    }
}