import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int[] minDif = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < array.length; i++) {
            if(minDif[1] > Math.abs(array[i] - n)){
                minDif[0] = array[i];
                minDif[1] = Math.abs(array[i] - n);
            }
        }
        return minDif[0];
    }
}