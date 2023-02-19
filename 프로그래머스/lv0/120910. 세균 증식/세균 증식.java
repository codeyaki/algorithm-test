class Solution {
    public int solution(int n, int t) {
        return n * pow(2, t);
    }
    int pow(int number, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return number;
        }
        int divCon = pow(number, exponent / 2);
        if (exponent % 2 == 1) {
            return divCon * divCon * pow(number, 1);
        } else {
            return divCon * divCon;
        }
    }
}