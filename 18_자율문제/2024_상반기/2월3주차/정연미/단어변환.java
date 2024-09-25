import java.util.*;

class Solution {
    static boolean[] visit;
    static int answer=0;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        DFS(begin, target, words, 0);
        return answer;
    }
    public static void DFS(String begin, String target, String[] words, int ans){
        if(begin.equals(target)){
            answer = ans;
            return;            
        }
        
        for(int i=0; i<words.length; i++){
            if(visit[i]) continue;
            int cnt =0; 
            for(int j=0; j<begin.length(); j++){
                 if(begin.charAt(j)==words[i].charAt(j)){
                    cnt++;
                }
            }
            
            if(cnt == begin.length()-1){
                visit[i] = true;
                DFS(words[i], target, words, ans+1);
                visit[i] = false;
            }
        }
    
    }
}


// 문자열 : length()
// 배열 : length

