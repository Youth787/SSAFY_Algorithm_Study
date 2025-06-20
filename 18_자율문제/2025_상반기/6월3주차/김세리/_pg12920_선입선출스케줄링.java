import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] cores) {
        if(n<=cores.length) return n;
        int left =0; int right = 200_000_000;
        int time=0;
        while(left<=right){
            int mid = (left+right)/2;
            long jobs = cores.length;
            for(int core:cores){
                jobs += mid/core;
            }
            if(jobs>=n){
                time = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        long jobs = cores.length;
        for(int core:cores){
            jobs += (time-1)/core;
        }
        for(int i=0;i<cores.length;i++){
            if(time%cores[i]==0){
                jobs++;
                if(jobs==n) return i+1;
            }
        }
        return -1;
    }
}
