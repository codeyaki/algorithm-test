class Solution {
    StringBuilder sb = new StringBuilder();

    public String solution(String s, String skip, int index) {
//        System.out.println(encrypString('z', "a", 1));
        for (int i = 0; i < s.length(); i++) {
            sb.append(encrypString(s.charAt(i), skip, index));
        }
        return sb.toString();
    }

    private char encrypString(char c, String skip, int index) {
        int intC = c - 'a';
        // 사이에 있는 알파벳 계산
        int key = index;
        while (key > 0) {

            intC = ((intC + 1) % 26);
            if (checkSkip(intC, skip)) {
                continue;
            }
            key--;
        }
        return (char) (intC + 'a');
    }

    private boolean checkSkip(int c, String skip) {
        // 만약 skip해야하는 문자 일경우 넘어가기
        for (int i = 0; i < skip.length(); i++) {
            if (skip.charAt(i) - 'a' == c) {
                return true;
            }
        }
        return false;
    }
}