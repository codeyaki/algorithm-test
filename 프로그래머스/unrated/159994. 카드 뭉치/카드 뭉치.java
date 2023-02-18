import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> QueCard1 = new LinkedList<>();
        Queue<String> QueCard2 = new LinkedList<>();
        for (int i = 0; i < cards1.length; i++) {
            QueCard1.add(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            QueCard2.add(cards2[i]);
        }

        for(int index = 0; index < goal.length; index++) {
            if (goal[index].equals(QueCard1.peek())) {
                QueCard1.poll();
            }else if (goal[index].equals(QueCard2.peek())) {
                QueCard2.poll();
            }else {
                return "No";
            }
        }
        return "Yes";
    }
}