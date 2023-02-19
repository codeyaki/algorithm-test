import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(Character.isDigit(c)) list.add(Character.getNumericValue(c));
        }
        list.sort(Comparator.naturalOrder());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}