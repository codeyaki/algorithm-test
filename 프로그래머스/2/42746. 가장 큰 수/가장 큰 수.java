import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        // 모든 원소가 0인 경우
        if(Arrays.stream(numbers).sum() == 0) return "0"; 
        Integer[] result = Arrays.stream(numbers).boxed().sorted((o1, o2) -> {
            int num1 = Integer.parseInt(o1 + "" + o2);
            int num2 = Integer.parseInt(o2 + "" + o1);
            return num2 - num1;
        }).toArray(Integer[]::new);
        return convertString(result);
    }
    
    private String convertString(Integer[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            sb.append(a);
        }
        return sb.toString();
    }
    
}