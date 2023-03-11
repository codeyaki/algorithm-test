import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < score.length; i++) {
            priorityQueue.add(score[i]);
            if(priorityQueue.size() > k) priorityQueue.poll();
            answer[i] = priorityQueue.peek();
        }
        return answer;
    }
}