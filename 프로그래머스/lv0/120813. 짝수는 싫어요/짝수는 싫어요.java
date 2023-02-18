import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        int[] oddArray = Arrays.stream(arr).filter(value -> value % 2 == 1).toArray();
        return oddArray;
    }
}