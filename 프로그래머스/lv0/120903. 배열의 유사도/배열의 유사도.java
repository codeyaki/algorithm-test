import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>();
        set.addAll(List.of(s1));
        set.addAll(List.of(s2));
        
        return s1.length + s2.length - set.size();
    }
}