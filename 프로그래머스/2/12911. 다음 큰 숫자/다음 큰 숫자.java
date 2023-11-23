class Solution {
    public int solution(int n) {
        int countTrueBit = Integer.bitCount(n);
        int compareNum = n + 1;
        while(Integer.bitCount(compareNum) != countTrueBit){
            compareNum++;
        }
        return compareNum;
    }
}