import java.util.*;

class Solution {
    private Map<String, List<String>> clothMap = new HashMap<>();
    public int solution(String[][] clothes) {
        for(String[] cloth : clothes){
            if(!clothMap.containsKey(cloth[1])) clothMap.put(cloth[1], new LinkedList<>());
            clothMap.get(cloth[1]).add(cloth[0]);
        }
        int answer = 1;
        
        for(String key : clothMap.keySet()){
            System.out.print(key + " ");
            System.out.println(clothMap.get(key));
            answer *= clothMap.get(key).size() + 1;
        }
        
        return answer - 1;
    }
}