import java.util.Arrays;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        Student[] studentArr = new Student[n];
        for(int i = 0; i < n; i++){
            studentArr[i] = new Student(i, score[i][0], score[i][1]);
        }
        for(int i = 0; i < n; i++){
            studentArr[i].setRank(studentArr);
        }
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = studentArr[i].rank;
        }
        return answer;
    }
    class Student{
        int order;
        int engScore;
        int mathScore;
        float average;
        int rank;
        public Student(int order, int engScore, int mathScore){
            this.order = order;
            this.engScore = engScore;
            this.mathScore = mathScore;
            this.average = (engScore + mathScore) / 2F;
        }
        public void setRank(Student[] studentArr){
            int rank = 1;
            for (Student student : studentArr) {
                if(student.average > this.average) rank++;
            }
            this.rank = rank;
        }

    }
}