import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minQue = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
        
        for(String op : operations) {
            String[] splitString = op.split(" ");
            String command = splitString[0];
            int num = Integer.parseInt(splitString[1]);
            if(command.equals("I")) {
                maxQue.add(num);
                minQue.add(num);
            }
            if(command.equals("D")) {
                if(num == 1 && maxQue.size() > 0) {
                    int deletedNum = maxQue.poll();
                    minQue.remove(deletedNum);
                } else if (num == -1 && minQue.size() > 0) {
                    int deletedNum = minQue.poll();
                    maxQue.remove(deletedNum);
                }
            }
        }
        
        
        int[] answer = maxQue.size() > 0 ? new int[]{maxQue.peek(), minQue.peek()} : new int[]{0, 0};
    
        return answer;
    }
}