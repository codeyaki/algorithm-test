class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = countRound(a - 1, b - 1);
        return answer;
    }
    // 0부터 인덱스
    private int countRound(int a, int b) {
        int count = 0;
        while (a != b){
            count++;
            a /= 2;
            b /= 2;
        }
        return count;
    }
}