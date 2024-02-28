import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> str1List = split2Str(str1);
        List<String> str2List = split2Str(str2);
        
        int intersectionCount = 0;
        int sizeSum = str1List.size() + str2List.size();
        
        // 둘다 공집합인 경우
        if(sizeSum == 0) return 1 * 65536;
        
        for(String s : str1List){
            if(str2List.contains(s)){
                intersectionCount++;
                str2List.remove(s);
            }
        }
        System.out.println(intersectionCount);
        return (int) ((float) intersectionCount / (float) (sizeSum - intersectionCount) * 65536.0f);
    }
    
    private boolean isAlpha(String str){
        for(int i = 0; i < str.length(); i++){
            Character c = str.charAt(i);
            if(!Character.isAlphabetic(c)){
                return false;
            }
        }
        return true;
    }
    
    private List<String> split2Str(String str) {
        List<String> result = new LinkedList<>();
        for(int i = 0; i < str.length() - 1; i++){
            String subString = str.substring(i, i+2);
            if(isAlpha(subString)) result.add(subString.toLowerCase());
        }
        return result;
    }
    
}