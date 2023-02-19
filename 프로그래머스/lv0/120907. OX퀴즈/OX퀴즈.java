class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] line = quiz[i].split(" ");
            int op = line[1].equals("+") ? 1 : -1;
            int result = Integer.parseInt(line[0]) + op * Integer.parseInt(line[2]);
            answer[i] = String.valueOf(result).equals(line[4]) ? "O" : "X";
        }
        return answer;
    }
}