import java.util.*;
class Solution {
    private Set<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        int n = elements.length;
        int[] sumArr = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sumArr[i] += elements[(i + j) % n];
                set.add(sumArr[i]);
            }
        }
        return set.size();
    }
}