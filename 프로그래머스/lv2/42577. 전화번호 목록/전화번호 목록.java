import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String>[] setArr = new Set[20 + 1];
        Arrays.sort(phone_book, ((o1, o2) -> o1.length() - o2.length()));
        for (int i = 0; i < setArr.length; i++) {
            setArr[i] = new HashSet<>();
        }
        for (String phone : phone_book) {
            for (int i = 1; i <= phone.length(); i++) {
                String s = phone.substring(0, i);
                if(setArr[i].contains(s)) return false;
            }
            setArr[phone.length()].add(phone);
        }
        boolean answer = true;
        return answer;
    }
}