import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todayArr = today.split("[.]");
        int todayTimestamp = convertTimestamp(Integer.parseInt(todayArr[0]), Integer.parseInt(todayArr[1]), Integer.parseInt(todayArr[2]));
        Map<String, Integer> termMap = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            StringTokenizer st = new StringTokenizer(terms[i]);
            termMap.put(st.nextToken(), Integer.parseInt(st.nextToken()) * 30);
        }

        List<Integer> destroyList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyLine = privacies[i].split(" ");
            StringTokenizer st = new StringTokenizer(privacyLine[0], "[.]");
            int date = convertTimestamp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            String termType = privacyLine[1];
            if (date + termMap.get(termType) <= todayTimestamp) {
                destroyList.add(i + 1);
            }
        }
        int[] answer = new int[destroyList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = destroyList.get(i);
        }
        return answer;
    }

    int convertTimestamp(int year, int month, int day) {
        return year * 360 + month * 30 + day;
    }
}