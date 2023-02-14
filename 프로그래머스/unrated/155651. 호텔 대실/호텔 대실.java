import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 예약 시작 시간 순으로 정렬
// 예약 되어있는 시간에 -10 , +10해서 겹치는지 확인
// 예약되어있는 모든 방이 겹칠 경우 새로운 방 배정
class Solution {
    List<int[]> roomList = new ArrayList<>();
    int[][] bookTimeToInt;

    public int solution(String[][] book_time) {
        // 시작시간 순으로 정렬
        bookTimeToInt = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            // 시작 시간 분으로 변경
            String[] split = book_time[i][0].split(":");
            bookTimeToInt[i][0] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            // 종료 시간 분으로 변경 ( +10분)
            split = book_time[i][1].split(":");
            bookTimeToInt[i][1] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]) + 10;
        }
        Arrays.sort(bookTimeToInt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else return 0;
            }
        });
        // 예약 확인

        book: for (int i = 0; i < bookTimeToInt.length; i++) {
            int startTime = bookTimeToInt[i][0];
            int endTime = bookTimeToInt[i][1];
            for (int[] room : roomList) {
                // 방을 돌며 예약시간 확인
                if (startTime >= room[1]) {
                    room[1] = endTime;
                    continue book;
                }
            }
            // 만약 만족하는 방이 없는 경우 새로 방을 준비
            int[] newRoom = new int[2];
            newRoom[0] = startTime;
            newRoom[1] = endTime;
            roomList.add(newRoom);
        }
        return roomList.size();
    }
}