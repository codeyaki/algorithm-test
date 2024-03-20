import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        for(int i = n - 1; i >= left; i--) {
            // 한명 더 태워나갈 수 있는 경우
            if(people[i] + people[left] <= limit) left++;
            answer++;
        }
        return answer;
    }
}