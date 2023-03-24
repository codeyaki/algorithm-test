class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        int[] purseSeqence1 = new int[sequence.length];
        int[] purseSeqence2 = new int[sequence.length];

        for(int i=0; i<sequence.length; i++) {
            if(i % 2 == 0) {
                purseSeqence1[i] = sequence[i];
                purseSeqence2[i] = sequence[i] * (-1);
            } else {
                purseSeqence1[i] = sequence[i] * (-1);
                purseSeqence2[i] = sequence[i];
            }
        }

        // purseSeqence1와 purseSeqence2 중에 가장 큰 부분합을 구하기
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];

        dp1[0] = purseSeqence1[0];
        dp2[0] = purseSeqence2[0];
        answer = Math.max(dp1[0], dp2[0]);

        for(int i=1; i<sequence.length; i++) {
            dp1[i] = Math.max(purseSeqence1[i], dp1[i-1] + purseSeqence1[i]);
            dp2[i] = Math.max(purseSeqence2[i], dp2[i-1] + purseSeqence2[i]);
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }

        return answer;
    }
}
