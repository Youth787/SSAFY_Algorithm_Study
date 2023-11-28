import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] cnt = new int[3];        
        List<Integer> answer = new ArrayList<>();
        
        int[] math1 = new int[]{1,2,3,4,5};
        int[] math2 = new int[]{2,1,2,3,2,4,2,5};
        int[] math3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        
            for(int j=0; j<answers.length; j++){
                if(math1[j%5]==answers[j]) cnt[0]++;
                if(math2[j%8]==answers[j]) cnt[1]++;
                if(math3[j%10]==answers[j]) cnt[2]++;
            }
        
        int max = 0;
        max = Math.max(cnt[2],Math.max(cnt[1],cnt[0]));
        for(int i=0; i<3; i++){
            if(cnt[i]==max)
                answer.add(i+1);
        }
            
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}