import java.util.*;
class Solution {
    private Map<Integer, Map<String, Integer>> countMap = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        for(int c : course) {
            countMap.put(c, new HashMap<>());
        }
        for(String order : orders) {
            String[] orderSplit = order.split("");
            Arrays.sort(orderSplit);
            String sortedOrder = String.join("", orderSplit);
            dfs(sortedOrder, new StringBuilder(), -1);
        }
        List<String> answer = new LinkedList<>();
        for(int n : course) {
            Map<String, Integer> countOrder = countMap.get(n);
            int max = 2;
            for(Integer value : countOrder.values()) {
                max = Math.max(value, max);
            }
            for(String key : countOrder.keySet()) {
                if(max == countOrder.get(key)) answer.add(key);
            }
        }
        return answer.stream().sorted((o1, o2) -> o1.compareTo(o2)).toArray(String[]::new);
    }
    
    private void dfs(String order, StringBuilder sb, int nowIndex) {
        if(countMap.containsKey(sb.length())) {
            Map<String, Integer> temp = countMap.get(sb.length());
            int count = temp.getOrDefault(sb.toString(), 0);
            temp.put(sb.toString(), count + 1);
        }
        for(int i = nowIndex + 1; i < order.length(); i++) {
            sb.append(order.charAt(i));
            dfs(order, sb, i);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}