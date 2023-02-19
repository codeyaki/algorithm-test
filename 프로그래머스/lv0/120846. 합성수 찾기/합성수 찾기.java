class Solution {
    boolean[] notPrimeNumberArr = new boolean[100 + 1];
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if(notPrimeNumberArr[i]) answer++;
        }
        return answer;
    }
    public Solution(){
        notPrimeNumberArr[0] = true;
        notPrimeNumberArr[1] = true;
        for(int i = 2; i <= Math.sqrt(100); i++){
            if(notPrimeNumberArr[i]) continue;
            for (int j = 2 * i; j <= 100; j += i) {
                notPrimeNumberArr[j] = true;
            }
        }

    }
}