import java.util.*;

class Solution {
    // 출발지 별 티켓 맵 설정
    Map<String, List<Ticket>> ticketMap = new HashMap<>();
    boolean isDone;
    int countTotalTicket;
    String[] answer;

    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            List<Ticket> ticketList = ticketMap.getOrDefault(ticket[0], new ArrayList<>());
            ticketList.add(new Ticket(ticket[1]));
            ticketMap.put(ticket[0], ticketList);
        }
        for (List<Ticket> ticketList : ticketMap.values()) {
            Collections.sort(ticketList);
        }
        countTotalTicket = tickets.length;
        isDone = false;
        answer = new String[countTotalTicket + 1];
        dfs("ICN", 0);
        return answer;
    }

    private void dfs(String now, int length) {
        answer[length] = now;

        // 종료 조건 = 모든 티켓을 다사용할것
        if (isDone || countTotalTicket == 0) {
            isDone = true;
            return;
        }
        if (ticketMap.get(now) == null) return;
        for (Ticket ticket : ticketMap.get(now)) {
            if (ticket.isUse || isDone) continue;
            ticket.isUse = true;
            countTotalTicket--;
            dfs(ticket.destiny, length + 1);
            ticket.isUse = false;
            countTotalTicket++;
        }
    }

    private class Ticket implements Comparable<Ticket> {
        String destiny; // 도착지
        boolean isUse; // 사용 유무

        public Ticket(String destiny) {
            this.destiny = destiny;
            this.isUse = false;
        }

        public int compareTo(Ticket o) {
            return this.destiny.compareTo(o.destiny);
        }
    }
}