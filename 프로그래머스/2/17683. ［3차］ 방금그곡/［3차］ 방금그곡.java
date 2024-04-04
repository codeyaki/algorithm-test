class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int answerPlayTime = 0;
        m = convertMelodyNoSharp(m);
        for(String musicInfo : musicinfos) {
            String[] temp = musicInfo.split(",");
            int playTime = stringToMinTime(temp[1]) - stringToMinTime(temp[0]);
            String name = temp[2];
            String melody = convertMelodyNoSharp(temp[3]);
            String fullMelody = makeFullMelody(melody, playTime);
            
            if(fullMelody.contains(m)) {
                if(answerPlayTime < playTime) {
                    answer = name;
                    answerPlayTime = playTime;
                }
            }
        }
        return answer;
    }
    
    private String makeFullMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melody.length()));
        }
        return sb.toString();
    }
    
    private String convertMelodyNoSharp(String melody) {
        melody = melody.replaceAll("C#", "c");
        melody = melody.replaceAll("D#", "d");
        melody = melody.replaceAll("E#", "e");
        melody = melody.replaceAll("F#", "f");
        melody = melody.replaceAll("G#", "g");
        melody = melody.replaceAll("A#", "a");
        melody = melody.replaceAll("B#", "b");
        return melody;
    }
    
    private int stringToMinTime(String timeString) {
        String[] temp = timeString.split(":");
        int hour = Integer.parseInt(temp[0]);
        int min = Integer.parseInt(temp[1]);
        return hour * 60 + min;
    }
}