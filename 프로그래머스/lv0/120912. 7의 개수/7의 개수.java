class Solution {
    public int solution(int[] array) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '7') answer++;
        }

        return answer;
    }
}