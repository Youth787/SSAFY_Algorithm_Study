import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int len = answers.length;

        //12345 21232425 3311224455
        int[] arr1 = new int [] {1,2,3,4,5};
        int[] arr2 = new int [] {2,1,2,3,2,4,2,5};
        int[] arr3 = new int [] {3,3,1,1,2,2,4,4,5,5};
        int[] scores = new int[3];

        for (int i = 0; i < len; i++) {
            if (arr1[i%5] == answers[i]) {
                scores[0]++;
            }
            if (arr2[i%8] == answers[i]) {
                scores[1]++;
            }
            if (arr3[i%10] == answers[i]) {
                scores[2]++;
            }
        }
      
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        int idx = 0;
        ArrayList <Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (scores[i] == max) {
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
