import java.util.*;


/**
 * 1. 장르별 재생 순위
 * 2. 장르내 노래별 재생 순위 (동일 시 고유번호 오름차순)
 **/
class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 장르별 총 재생수 합계내기
        Map<String, List<Music>> genreMap = new HashMap<>();
        Map<String, Integer> playsByGenre = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!genreMap.containsKey(genres[i])) genreMap.put(genres[i], new LinkedList<>());
            if (!playsByGenre.containsKey(genres[i])) playsByGenre.put(genres[i], 0);
            genreMap.get(genres[i]).add(new Music(i, plays[i]));
            playsByGenre.put(genres[i], playsByGenre.get(genres[i]) + plays[i]);
        }
        List<String> genreList = new LinkedList<>(genreMap.keySet());
        Collections.sort(genreList, (o1, o2) -> playsByGenre.get(o2) - playsByGenre.get(o1));

        List<Integer> answerList = new ArrayList<>();
        for (String genreName : genreList) {
            List<Music> musicList = genreMap.get(genreName);
            Collections.sort(musicList, ((o1, o2) -> {
                if (o1.play == o2.play) return o1.no - o2.no;
                return o2.play - o1.play;
            }));
            // 최대 두개만 뽑아 내기
            for(int i = 0; i < musicList.size() && i < 2; i++){
                answerList.add(musicList.get(i).no);
            }
        }
        // 출력
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private class Music {
        private int no;
        private int play;

        public Music(int no, int play) {
            this.no = no;
            this.play = play;
        }
    }
}