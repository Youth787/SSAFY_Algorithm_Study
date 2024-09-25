import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {

        int length = answers.length;
        //1번 사람
        int[] one = new int[length];
        for (int i = 0; i < length; i++) {
           one[i] = i % 5 + 1; 
        }
      //2번사람
        int[] two = new int[length];
        int count = 1;
        for (int i = 0; i < length; i++) {
           if (i % 2 == 0) {
               two[i] = 2;
           } else {
                if (count == 6) {
                count = 1;
                } else if (count == 2) {
                   count++;
               }
               two[i] = count;
               count++;

            }


        }
        //3번사람
        int[] three = new int[length];
        for (int i = 0; i < length; i++) {
            if (i % 10 == 0 || i % 10 == 1) {
                three[i] = 3;
            } else if (i % 10 == 2 || i % 10 == 3) {
                three[i] = 1;
            } else if (i % 10 == 4 || i % 10 == 5) {
                three[i] = 2;
            } else if (i % 10 == 6 || i % 10 == 7) {
                three[i] = 4;
            } else if (i % 10 == 8 || i % 10 == 9) {
                three[i] = 5;
            } 
        }
        //각자 얼마나 정답이랑 맞는지 카운트 체크해서
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < length; i++) {
            if (answers[i] == one[i]) count1++;
            if (answers[i] == two[i]) count2++;
            if (answers[i] == three[i]) count3++;
        }
      // 최대값구하고 counts배열에 넣는다.
        int max = Math.max(count1, Math.max(count2, count3));
        int[] counts = {count1, count2, count3};
      // 만약 최대값과 count가 같다면 정답에 넣어줄것임
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (max == counts[i]) {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        for(int i: counts) {
            System.out.print(i);
        }
        return answer;

    }
}
