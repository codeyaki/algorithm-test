class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        l -= 1;
        while(l < r) {
            if(check(l)) answer++;
            l++;
        }
        return answer;
    }
    
    private boolean check(long l) {
        if(l % 5 == 2) return false;
        else if(l < 5) return true;
        
        return check(l / 5);
    }
}