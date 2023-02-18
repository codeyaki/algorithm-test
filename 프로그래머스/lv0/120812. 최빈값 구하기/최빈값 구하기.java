import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

class Solution {
    public int solution(int[] array) {
        int[][] cntNumber = new int[1001][2];
        for (int i = 0; i < 1001; i++) {
            cntNumber[i][0] = i;
        }
        for (int i = 0; i < array.length; i++) {
            cntNumber[array[i]][1]++;
        }
        Arrays.sort(cntNumber, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return  -1;
                } else if (o1[1] == o2[1]) {
                    return 0;
                } else {
                    return 1;
                } 
            }
        });
        return cntNumber[0][1] == cntNumber[1][1] ? -1 : cntNumber[0][0];
    }
}