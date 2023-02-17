class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        String loopA = A;
        while (answer < A.length()){
            if(loopA.equals(B)) return answer;
            StringBuffer newSbA = new StringBuffer();
            newSbA.append(loopA.charAt(loopA.length() - 1));
            for (int i = 0; i < A.length() - 1; i++) {
                newSbA.append(loopA.charAt(i));
            }
            loopA = newSbA.toString();
            answer++;
        }
        return -1;
    }
}