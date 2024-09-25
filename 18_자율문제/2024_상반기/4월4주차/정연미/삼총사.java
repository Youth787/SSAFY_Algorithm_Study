import java.util.*;

// 중복 허용 
// 조합 
class Solution {
    int answer = 0;
    public int solution(int[] number) {
        int r = 3;
        List<Integer> chosen = new ArrayList<>();
        combine(chosen, number, 0,r);
        return answer;
    }
    
    public void combine(List<Integer> chosen, int[] number, int index, int r){
        if(chosen.size() == r){
            int sum = chosen.stream().reduce(0,(a,b)->a+b);
            if(sum==0) {
                answer ++;
            }
            System.out.println(chosen);
            return;
        }
        
        for(int i=index; i<number.length; i++){
            chosen.add(number[i]);
            combine(chosen, number, i+1, r);
            chosen.remove(chosen.size()-1);
        }
    }
    
}
