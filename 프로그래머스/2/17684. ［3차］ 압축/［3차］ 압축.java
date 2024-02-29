import java.util.*;

class Solution {
    List<String> cache;
    
    public Solution() {
        cache = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            cache.add(Character.toString('A'+i));
        }
    }
    
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        String[] splitMsg = msg.split("");
        for(int i = 0; i < splitMsg.length; i++) {
            String w = splitMsg[i];
            for(int j = i + 1; j < splitMsg.length; j++){
                String c = splitMsg[j];
                if(cache.contains(w + c)){
                    w += c;
                    i = j;
                }else {
                    cache.add(w+c);
                    answer.add(cache.indexOf(w) + 1);
                    break;
                }
            }
            if(i == splitMsg.length - 1){
                answer.add(cache.indexOf(w) + 1);
            }
            
        }
        return convertToArray(answer);
    }
    private int[] convertToArray(List<Integer> list){
        int size = list.size();
        int[] res = new int[size];
        for(int i = 0; i < size; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}