import java.util.*;

class Solution {
    int answer = 0;
    boolean[] visit;
    int[] numarr;
    int[] result;
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        
        visit = new boolean[numbers.length()];
        numarr = new int[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++)
            numarr[i] = numbers.charAt(i)-'0';
        
        for(int i=1; i<=numbers.length(); i++){
            result = new int[i];
            npr(numarr,numbers.length(),i,0);
        }
        
        return answer;
    }
    
    public void npr(int[] arr, int n , int idx, int sidx){
        if(sidx==idx){
            StringBuilder sb = new StringBuilder();            
            for(int i=0; i<result.length; i++) sb.append(result[i]);
            int resultnum = Integer.parseInt(sb.toString());
            if(!set.contains(resultnum)){
                set.add(resultnum);
                if(prime(resultnum)) answer ++; 
            }
            return;
        }
        
        for(int i=0; i<n; i++){
            if(visit[i]) continue;
            result[sidx] = numarr[i];
            visit[i] = true;
            npr(arr, n, idx, sidx+1);
            visit[i] = false;
        }
    }
    
    public boolean prime(int num){
        if(num==0 || num==1) return false;
        if(num>=2){
            for(int i=2; i<num; i++) if(num%i==0) return false;
        }
        return true;
    }
}
