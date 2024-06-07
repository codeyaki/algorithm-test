class Solution {
    public int[] solution(long begin, long end) {
        int n = (int) (end - begin + 1);
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = getMaxPrimary(begin + (long) i);
        }
        return answer;
    }
    
    // 약수중 가장 큰 수 구하기
    private int getMaxPrimary(long num) {
        if(num == 1L) return 0;
        int result = 1;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                result = Math.max(result, i);
                if(((int) (num / i)) <= 10000000) result = Math.max((int) (num / i), result);
            }
        }
        return result;
    }
}