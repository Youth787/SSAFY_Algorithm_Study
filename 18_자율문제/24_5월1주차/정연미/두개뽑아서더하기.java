import java.util.*;

// 조합 문제. 
// visit 필요없음

class Solution {
    List<Integer> chosen = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    public int[] solution(int[] numbers) {
        int[] answer = {};
        ncr(numbers, 0);
        Collections.sort(result);
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    public void ncr(int[] numbers, int idx){
        if(chosen.size()==2){
            int sum = chosen.get(0)+chosen.get(1);
            if(!result.contains(sum)){
                result.add(sum);
            }
            return;
        }
        
        for(int i=idx; i<numbers.length; i++){
            chosen.add(numbers[i]);
            ncr(numbers,i+1);
            chosen.remove(chosen.size()-1);
        }
        
        
    }
}
