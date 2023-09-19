import java.util.*;

class Solution{
    public int solution(int[] A, int[] B){
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            answer += A[i] * B[n - i - 1];
        }

        return answer;
    }
}