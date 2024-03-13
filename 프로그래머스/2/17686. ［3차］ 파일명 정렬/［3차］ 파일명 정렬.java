import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int n = files.length;
        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fileList.add(new File(files[i], i));
        }
        fileList.sort((o1, o2) -> {
            if(o1.head.equals(o2.head)){
                if (o1.number == o2.number) {
                    return o1.inputOrder - o2.inputOrder;
                }
                return o1.number - o2.number;
            }
            return o1.head.compareTo(o2.head);
        });
        
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            answer[i] = fileList.get(i).origin;
        }
        return answer;
    }
    
    class File {
        String origin;
        String head;
        int number;
        String tail;
        int inputOrder;
        
        File(String fileName, int inputOrder) {
            this.origin = fileName;
            parseFileName(fileName);
            this.inputOrder = inputOrder;
        }
        
        private void parseFileName(String fileName) {
            String type = "HEAD";
            StringBuilder head = new StringBuilder();
            head.append(fileName.charAt(0));
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            for(int i = 1; i < fileName.length(); i++) {
                char c = fileName.charAt(i);
                // 해당 인덱스가 HEAD인지 NUMBER인지 TAIL인지 확인
                // HEAD는 그대로, NUMBER는 숫자가 처음오면서 타입이 HEAD인 경우
                // TAIL은 숫자가 끝나면서 타입이 NUMBER인 경우
                if(Character.isDigit(c) && type.equals("HEAD")) type = "NUMBER";
                else if(!Character.isDigit(c) && type.equals("NUMBER")) type = "TAIL";
                
                if(type.equals("NUMBER")) number.append(c);
                else if(type.equals("TAIL")) tail.append(c);
                else head.append(c);
            }
            
            this.head = head.toString().toUpperCase();
            this.number = Integer.valueOf(number.toString());
            this.tail = tail.toString();
        }
        
        public String toString(){
            return String.valueOf(this.number);
        }
    }
}