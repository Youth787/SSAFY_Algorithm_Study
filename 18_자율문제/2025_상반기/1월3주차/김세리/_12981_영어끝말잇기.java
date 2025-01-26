import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        List<String> list = new ArrayList<>();
        char last = words[0].charAt(words[0].length()-1);
        list.add(words[0]);
        int chk = 0;
        
        for(int i=1;i<words.length;i++){
            if(words[i].charAt(0)==last && !list.contains(words[i])){
                last = words[i].charAt(words[i].length()-1);
                list.add(words[i]);
            } else{
                chk=i+1;
                break;
            }
        }
        // System.out.println(chk);
        if(chk!=0){
            if(chk%n==0){
                answer[0]=n;
                answer[1]=chk/n;
            } else{
                answer[0]=chk%n;
                answer[1]=chk/n+1;
            }
        }
        

        return answer;
    }
}
