import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String num="";
        int tmp =0;
        while(num.length()<t*m*2){
            String tmp2 = Integer.toString(tmp,n).toUpperCase();
            num += tmp2;
            tmp++;
        }
        System.out.println(num);
        
        String answer = "";
        for(int i=0;i<t;i++){
            int tmp3 = i*m+p-1;
            answer += num.substring(tmp3,tmp3+1);
        }        
        
        return answer;
    }
}
