class Solution {
    public int solution(int a, int b) {
        int gcd = gcd(Math.max(a, b), Math.min(a,b));
        int demo = b / gcd;
        int d = 2;
        while(demo > 1){
            if(demo % d == 0){
                if(d == 2 || d == 5) demo /= d;
                else return 2;
            }else {
                d++;
            }
        }
        return 1;
    }
    int gcd(int a, int b){
        if(a%b==0) return b;
        return gcd(b, a%b);
    }
}