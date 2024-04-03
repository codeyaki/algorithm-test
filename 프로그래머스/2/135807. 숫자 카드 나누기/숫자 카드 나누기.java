import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int n = arrayA.length;
    
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < n; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        boolean[] isNotA = new boolean[2];
        for(int i = 0 ; i < n; i++) {
            if(arrayB[i] % gcdA == 0) isNotA[0] = true;
            if(arrayA[i] % gcdB == 0) isNotA[1] = true;
        }
        if(!isNotA[0] && isNotA[1]) return gcdA;
        else if(isNotA[0] && !isNotA[1]) return gcdB;
        else if(!isNotA[0] && !isNotA[1]) return Math.max(gcdA, gcdB);
        return 0;
    }
    
    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}