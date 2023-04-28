import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) throws IOException {
        Node root = read();
        root.preorderTraversal();
        System.out.println("");
        root.inorderTraversal();
        System.out.println("");
        root.postorderTraversal();
    }

    private static Node read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // root 는 항상 A노드
        Node root = new Node("A");
        // nodeMap
        Map<String, Node> nodeMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = Character.toString('A' + i);
            nodeMap.put(name, new Node(name));
        }
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            Node node = nodeMap.get(line[0]);
            if (!line[1].equals(".")) {
                node.left = nodeMap.get(line[1]);
            }
            if (!line[2].equals(".")) {
                node.right = nodeMap.get(line[2]);
            }
        }
        return nodeMap.get("A"); // 루트 노드는 항상 A

    }

    private static class Node{
        String name;
        Node left;
        Node right;

        public Node(String name){
            this.name = name;
        }

        private void preorderTraversal(){
            System.out.print(this.name);
            // 전위 순회
            if(left != null){
                left.preorderTraversal();
            }
            if(right != null){
                right.preorderTraversal();
            }
        }
        private void inorderTraversal(){
            // 중위 순위
            if(left != null){
                left.inorderTraversal();
            }
            System.out.print(this.name);
            if(right != null){
                right.inorderTraversal();
            }
        }

        private void postorderTraversal(){
            // 후위 순위
            if(left != null){
                left.postorderTraversal();
            }
            if(right != null){
                right.postorderTraversal();
            }
            System.out.print(this.name);
        }
    }
}
