class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int r = storey % 10;
            // 4 이하는 무조건 내리기
            if (r < 5) {
                answer += r;
            }
            // 5 이상은 무조건 올리기
            else if (r > 5) {
                answer += 10 - r;
                storey += 10;
            }
            // r이 5일때는 다음 수를 봐야함
            if (r == 5) {
                if ((storey / 10) % 10 > 4) {
                    answer += 10 - r;
                    storey += 10;
                } else {
                    answer += r;
                }
            }
            storey /= 10;
        }
        return answer;
    }
}