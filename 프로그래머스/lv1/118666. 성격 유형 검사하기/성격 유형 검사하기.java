class Solution {

    public String solution(String[] survey, int[] choices) {
        int[] scores = new int[4]; // RT, CF, JM, AN;
        for(int i = 0; i < survey.length; i++){
            choices[i] -= 4;
            switch (survey[i]){
                // RT
                case "RT":
                    choices[i] *= -1;
                case "TR":
                    scores[0] += choices[i];
                    break;
                // CF
                case "CF":
                    choices[i] *= -1;
                case "FC":
                    scores[1] += choices[i];
                    break;
                // JM
                case "JM":
                    choices[i] *= -1;
                case "MJ":
                    scores[2] += choices[i];
                    break;
                // AN
                case "AN":
                    choices[i] *= -1;
                case "NA":
                    scores[3] += choices[i];
                    break;
            }
        }
        StringBuffer answer = new StringBuffer();
        char[][] chars = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        for (int i = 0; i < 4; i++) {
            if(scores[i] >= 0) answer.append(chars[i][0]);
            else answer.append(chars[i][1]);
        }
        return answer.toString();
    }
}