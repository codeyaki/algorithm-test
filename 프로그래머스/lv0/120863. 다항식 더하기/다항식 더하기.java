import java.util.StringTokenizer;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int coefficient = 0;
        int constant = 0;
        StringTokenizer st = new StringTokenizer(polynomial, "+");
        while (st.hasMoreElements()) {
            String s = st.nextToken().trim();
            if (s.contains("x")) {
                s = s.replaceAll("x", "");
                if(s.equals("")) s = "1";
                coefficient += Integer.parseInt(s);
            } else {
                constant += Integer.parseInt(s.trim());
            }

        }
        StringBuffer sb = new StringBuffer();
        if(coefficient > 1) sb.append(coefficient);
        if(coefficient > 0) sb.append("x");
        if(coefficient > 0 && constant > 0) sb.append(" + ");
        if(constant > 0) sb.append(constant);
        return sb.toString();
    }
}