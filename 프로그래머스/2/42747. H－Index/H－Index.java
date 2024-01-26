class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for(int h = 0; h < 10000 + 1; h++) {
            int underH = 0;
            int upperH = 0;
            for(int i = 0; i < citations.length; i++){
                if(citations[i] >= h) upperH++;
                if(citations[i] <= h) underH++;
            }
            if(underH <= h && upperH >= h) answer = h;
        }
        return answer;
    }
}