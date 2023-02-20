import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        patient[] patientsArr = new patient[n];
        for (int i = 0; i < n; i++) {
            patientsArr[i] = new patient(i, emergency[i]);
        }
        Arrays.sort(patientsArr, new Comparator<patient>() {
            @Override
            public int compare(patient o1, patient o2) {
                return o2.emergency - o1.emergency;
            }
        });
        int[] orderChart = new int[n];
        for (int i = 0; i < n; i++) {
            orderChart[patientsArr[i].order] = i + 1;
        }
        return orderChart;
    }
    class patient{
        int order;
        int emergency;
        int rank;
        public patient(int order, int emergency) {
            this.order = order;
            this.emergency = emergency;
        }
    }
}