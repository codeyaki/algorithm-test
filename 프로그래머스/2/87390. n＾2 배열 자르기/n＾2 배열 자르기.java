class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int index = 0;
        for(long i = left; i <= right; i++){
            int flag = (int) (i / n) - (int) (i % n);
            if(flag < 0) flag = 0;
            answer[index++] = (int) (flag + (i % n) + 1L);
        }
        return answer;
    }
}