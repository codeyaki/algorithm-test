class Solution {
    private int[] arr = new int[2001];
    public long solution(int n) {
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 1; i <= n; i++){
            // 1칸 뛰기
            arr[i+1] = (arr[i+1] + arr[i]) % 1234567;
            // 2칸 뛰기
            arr[i+2] = (arr[i+2] + arr[i]) % 1234567;
        }
        return arr[n];
    }
}