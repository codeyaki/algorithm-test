class Solution {
    boolean[] isPaint;
    public int solution(int n, int m, int[] section) {
        isPaint = new boolean[n];
        int answer = 0;
        for(int i : section){
            isPaint[i - 1] = true;
        }
        for(int i = 0; i < n; i++){
            if(isPaint[i] == true) {
                paint(i, m, n);
                answer++;
            }
        }
        return answer;
    }
    void paint(int block, int count, int end){
        while(block < end && count-- > 0){
            isPaint[block++] = false;
        }
    }
}