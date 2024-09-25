// int 배열을 list 로 변환해주는 이유는 Integer 자료형을 담기 위해서이다. 
// Collections.sort(list, (a,b)->{});
// Integer.parseInt() -> 문자열 정수값으로 변환 
// Integer.compare : 두 정수값 비교 
// return 뒤의 -값은 내림차순 의미 


import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, (a,b)->{
            String aa = String.valueOf(a);
            String bb = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(aa+bb),Integer.parseInt(bb+aa));
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        answer = sb.toString();
        if(answer.charAt(0)=='0') answer = "0";
        return answer;
    }
}

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
