import java.io.*;
import java.util.*;

/**
 * 입력:
 *  - 사람: 1부터 N번의 사람 (N명)
 *  - 파티: 0부터 M-1의 파티 (M개)
 * 1. 진실을 알고 있는사람 리스트화 => knowTruthArr ( length = K )
 * 2. 진실을 알고 있는 사람과 함께 파티를 갖은 사람 리스트화
 *  2.1 진실을 알고 있는 사람을 root
 *  2.2 해당 인원이 참가한 파티 순회
 *  2.3 2.2에서 찾은 파티에 참가한 인원들을 Queue에 담기
 *  2.4 2.2 ~ 2.3 반복
 * 3. 해당 사람들이 참가한 파티 제외
 * 4. 개수 확인
 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<Integer> knowTruthArr; // 진실을 알고 있는 사람들
    static Stack<Integer>[] partyMemberStackArr, // 파티에 참가한 명단
                            visitedPartyStackArr; // 해당 사람이 참가한 파티
    static boolean[] visitedParty, visitedPeople;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수
        // 진실을 아는 사람 리스트 구하기
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
        knowTruthArr = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            knowTruthArr.add(Integer.parseInt(st.nextToken()));
        }
        // 파티에 참가한 명단, 참가한 파티 구하기
        partyMemberStackArr = new Stack[m]; // 0 ~ m-1 파티에 참가한 인원들
        visitedPartyStackArr = new Stack[n + 1]; // 1~n 각 인원별 참가한 파티들
        // 초기화
        for (int i = 0; i < m; i++) {
            partyMemberStackArr[i] = new Stack<>();
        }
        for (int i = 0; i < n + 1; i++) {
            visitedPartyStackArr[i] = new Stack<>();
        }
        for (int party = 0; party < m; party++) {
            st = new StringTokenizer(br.readLine());
            int partyN = Integer.parseInt(st.nextToken()); // 파티에 참가한 인원수
            for (int i = 0; i < partyN; i++) {
                int member = Integer.parseInt(st.nextToken());
                partyMemberStackArr[party].push(member);
                visitedPartyStackArr[member].push(party);
            }
        }
        // bfs를 통해 해당 진실을 아는 자와 함께 파티를 즐긴사람 확인
        visitedParty = new boolean[m];
        visitedPeople = new boolean[n + 1];
        bfs();

        // 진실을 알았던 사람들이 방문하지 않은 파티 개수 계산
        int result = 0;
        for (boolean b : visitedParty) {
            if(!b) result++;
        }
        // 출력
        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        while (!knowTruthArr.isEmpty()) {
            int next = knowTruthArr.poll();
            // 해당 사람이 방문한 파티 순회하기
            for (int party : visitedPartyStackArr[next]) {
                visitedParty[party] = true;
                // 각 파티의 인원들 담기
                // 해당 사람이 이미 방문했을 경우 넘어가기
                for (int partyMember : partyMemberStackArr[party]) {
                    if(visitedPeople[partyMember]) continue;
                    visitedPeople[partyMember] = true;
                    knowTruthArr.add(partyMember);
                }
            }
        }
    }
}