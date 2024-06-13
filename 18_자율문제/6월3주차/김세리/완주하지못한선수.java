import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int N = participant.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            if(!map.containsKey(participant[i])){
                map.put(participant[i],1);
            }
            else{
                int tmp = map.get(participant[i]);
                map.remove(participant[i]);
                map.put(participant[i],tmp+1);
            }
        }
        int M = completion.length;
        for(int i=0;i<M;i++){
            int tmp = map.get(completion[i]);
            if(tmp==1) map.remove(completion[i]);
            else{
                map.remove(completion[i]);
                map.put(completion[i],tmp-1);
            }
        }
        
        for(String temp : map.keySet()){
            answer = temp;
        }
        
        return answer;
    }
}
