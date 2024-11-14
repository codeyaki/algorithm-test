class Solution {
    public int solution(int a, int b) {
        int num1 = Integer.parseInt(a + "" + b);
        int num2 = 2 * a * b;
        return Math.max(num1, num2);
    }
}