class Solution {
    public String solution(String bin1, String bin2) {
        int plus = toDecimal(bin1) + toDecimal(bin2);
        return toBinary(plus);
    }

    int toDecimal(String binary) {
        int result = 0;
        int d = 1;
        for (int i = binary.length() - 1; i > -1; i--) {
            result += (binary.charAt(i) - '0') * d;
            d *= 2;
        }
        return result;

    }

    String toBinary(int decimal) {
        StringBuilder result = new StringBuilder();
        while (decimal > 1) {
            result.insert(0, decimal % 2);
            decimal /= 2;
        }
        result.insert(0, decimal);
        return result.toString();
    }
}