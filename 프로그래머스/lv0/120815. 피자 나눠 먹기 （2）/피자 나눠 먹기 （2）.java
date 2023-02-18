class Solution {
    public int solution(int n) {
        int gcd = gcd(n,6);
        return n / gcd;
    }
    int gcd(int a, int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }
}