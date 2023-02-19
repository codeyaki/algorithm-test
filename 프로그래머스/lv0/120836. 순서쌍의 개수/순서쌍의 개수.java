import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return (int) IntStream.range(1, n + 1).filter(i -> n % i == 0).count();
    }
}