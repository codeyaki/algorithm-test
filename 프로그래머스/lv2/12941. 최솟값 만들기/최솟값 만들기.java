import java.util.*;

class Solution{
    public int solution(int[] A, int[] B){
        int n = A.length;
        Integer[] boxedA = new Integer[n];
        Integer[] boxedB = new Integer[n];
        for(int i = 0; i < n; i++){
            boxedA[i] = A[i];
            boxedB[i] = B[i];
        }
        Arrays.sort(boxedA);
        Arrays.sort(boxedB, Collections.reverseOrder());
        int answer = 0;
        for(int i = 0; i < A.length; i++){
            answer += boxedA[i] * boxedB[i];
        }

        return answer;
    }
}