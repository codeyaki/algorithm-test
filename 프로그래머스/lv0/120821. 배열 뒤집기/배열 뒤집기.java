import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] num_list) {
        int[] reversedNumList = new int[num_list.length];
        for (int i = 0; i < num_list.length; i++) {
            reversedNumList[i] = num_list[num_list.length - i - 1];
        }
        return reversedNumList;

    }
}