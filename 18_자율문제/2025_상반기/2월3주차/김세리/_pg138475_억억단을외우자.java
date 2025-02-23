import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        // 등장 횟수 = 약수 개수
        int[] count = new int[e+1];

        for(int i=1;i<=e;i++){
            for(int j=i;j<=e;j+=i){
                count[j]++;
            }
        }
        int[] maxNum = new int[e+1];
        int maxIdx=e;
        for(int i=e;i>=1;i--){
            if(count[i]>=count[maxIdx]){
                maxIdx=i;
            }
            maxNum[i]=maxIdx;
        }
        // System.out.println(Arrays.toString(count));
        // System.out.println(Arrays.toString(maxNum));
        for(int i=0;i<starts.length;i++){
            answer[i]=maxNum[starts[i]];
        }
        return answer;
    }
}
