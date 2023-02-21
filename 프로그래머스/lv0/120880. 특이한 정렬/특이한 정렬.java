import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public Integer[] solution(int[] numlist, int n) {
        List<Integer> nList = Arrays.stream(numlist).boxed().collect(Collectors.toList());
        nList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int dis1 = Math.abs(o1 - n);
                int dis2 = Math.abs(o2 - n);

                if (dis1 == dis2) {
                    return o2 - o1;
                }
                return dis1 - dis2;
            }
        });
        Integer[] answer = nList.toArray(Integer[]::new);


        return answer;
    }

}