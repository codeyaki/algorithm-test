import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        String[] split = s.split("}");
        List<String[]> list = new ArrayList();
        for(int i = 0; i < split.length; i++){
            split[i] = split[i].replace(",{", "");
            split[i] = split[i].replace("{", "");
            list.add(split[i].split(","));
        }
        Collections.sort(list, (o1, o2) -> o1.length - o2.length);
        
        List<String> answerList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            for(String ff : list.get(i)){
                if(answerList.contains(ff)) continue;
                answerList.add(ff);
            }
        }
        return answerList.stream().mapToInt(Integer::parseInt).toArray();
    }
}