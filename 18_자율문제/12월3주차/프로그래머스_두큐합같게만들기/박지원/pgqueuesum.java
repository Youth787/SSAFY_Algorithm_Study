class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total1 = 0; // q1 합
        long total2 = 0; // q2 합
        
        for (int i = 0; i < queue1.length; i++) {
            total1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            total2 += queue2[i];
        }
        if ((total1 + total2) % 2 != 0) return -1;
        
        int cnt1 = 0;
        boolean num1 = false; // 큐1의 모든 원소를 다 넘기면 true >> total에 더해줄때 필요
        int cnt2 = 0;
        boolean num2 = false;

        a: while (total1 != total2) {
            if (total1 > total2) {
                if (!num1) {
                    total1 -= queue1[cnt1];
                    total2 += queue1[cnt1];    
                } else {
                    total1 -= queue2[cnt1];
                    total2 += queue2[cnt1];
                }
                cnt1++;
                answer++;
            } else if (total1 < total2) {
                if (!num2) {
                    total2 -= queue2[cnt2];
                    total1 += queue2[cnt2];
                } else {
                    total2 -= queue1[cnt2];
                    total1 += queue1[cnt2];
                }
                cnt2++;
                answer++;
            }
            if (cnt1 >= queue1.length) {
                cnt1 = 0;
                num1 = true;
            } else if (cnt2 >= queue2.length) {
                cnt2 = 0;
                num2 = true;
            }
            if (answer > queue1.length * 4) { // 가능한 전부의 경우의수를 다했다면 ? while문 멈추기.
                answer = -1;
                break a;
            }
        }
        
        return answer;
    }
}
