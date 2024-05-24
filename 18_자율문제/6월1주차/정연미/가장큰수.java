

// 시간초과 발생 
import java.util.*;

class Solution {
    int[] result;
    boolean[] visit;
    int size;
    String answer = "";
    int[] arr;
    List<String> stresult = new LinkedList<>();
    public String solution(int[] numbers) {
        arr = numbers;
        size = numbers.length;
        result = new int[size];
        visit = new boolean[size];
        npr(0);
        Collections.sort(stresult, Collections.reverseOrder());
        answer = stresult.get(0);
        return answer;
    }
    public void npr(int idx){
        if(idx == size){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<size; i++)
                sb.append(Integer.toString(result[i]));
            stresult.add(sb.toString());
            return; 
        }
        
        for(int i=0; i<size; i++){
            if(visit[i]) continue;
            result[idx] = arr[i];
            visit[i] = true;
            npr(idx+1);
            visit[i] = false;
        }
    }
}
