class Solution {
    public int[] solution(int[] num_list, int n) {
        int m = (int) Math.ceil((double) num_list.length / (double) n);
        int[] answer = new int[m];
        for(int i = 0; i < m; i++ ){
            answer[i] = num_list[i*n];
        }
        
        return answer;
    }
}