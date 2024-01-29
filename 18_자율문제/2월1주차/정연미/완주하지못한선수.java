import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for(String a : participant) map.put(a, map.getOrDefault(a,0)+1);
        for(String b : completion) map.put(b, map.get(b)-1);
        for(String a : participant){
            if(map.get(a) > 0 ) answer = a;
        }
        return answer;
    }
}