import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nKLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nKLine[0]; // 보석 개수
        int k = nKLine[1]; // 가방 개수
        PriorityQueue<Jewel> jewelQue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        List<Integer> backpackQue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int[] jewelInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            jewelQue.add(new Jewel(jewelInput));
        }
        for (int i = 0; i < k; i++) {
            int backpackInput = Integer.parseInt(br.readLine());
            backpackQue.add(backpackInput);
        }
        backpackQue.sort((o1, o2) -> o1 - o2);

        // 현재 가방에 담을 수 있는 보석 목록
        PriorityQueue<Jewel> canJewelQue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        // 가장 비싼거부터 가장 작은 가방에 들어갈 수 있는대로 넣기
        long total = 0;
        for (int backpack : backpackQue) {
            // 넣을 수 있는 만큼 넣기
            while (!jewelQue.isEmpty() && jewelQue.peek().weight <= backpack)
                canJewelQue.add(jewelQue.poll());
            // 넣을 수 있는것중 가장 가치 있는것 넣기
            if (!canJewelQue.isEmpty())
                total += canJewelQue.poll().value;
        }

        System.out.println(total);

    }
}

class Jewel {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public Jewel(int[] jewelInput) {
        this.weight = jewelInput[0];
        this.value = jewelInput[1];
    }

    public String toString() {
        return "j{" + weight + ", " + value + "}";
    }

}