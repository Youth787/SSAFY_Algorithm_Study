import java.util.*;
import java.io.*;

class Solution {
    static int maxDiff;
    static int[] answer;
    public int[] solution(int n, int[] info) {
        maxDiff=0;
        answer = new int[11];
        int[] ryan = new int[11];
        
        dfs(0, n, info, ryan);
        
        return maxDiff==0 ? new int[]{-1} : answer;
        
    }

    static void dfs(int index, int arrowsLeft, int[] info, int[] ryan){
        if(index==11){
            if(arrowsLeft > 0) ryan[10] +=arrowsLeft;
            checkScore(info, ryan);
            if(arrowsLeft > 0) ryan[10] -=arrowsLeft;
            return;
        }
        if(arrowsLeft>info[index]){
            ryan[index] = info[index]+1;
            dfs(index+1, arrowsLeft-ryan[index], info, ryan);
            ryan[index]=0;
        }
        dfs(index+1,arrowsLeft,info,ryan);
    }
    static void checkScore(int[] info, int[] ryan){
        int aScore=0, rScore=0;
        for(int i=0;i<11;i++){
            if(info[i]==0 && ryan[i]==0) continue;
            if(info[i]>=ryan[i]) aScore += 10-i;
            else rScore += 10-i;
        }
        int diff = rScore-aScore;
        if(diff>maxDiff){
            maxDiff=diff;
            answer = ryan.clone();
        } else if(diff==maxDiff){
            for(int i=10;i>=0;i--){
                if(ryan[i]>answer[i]){
                    answer=ryan.clone();
                    break;
                } else if(ryan[i]<answer[i]) break;
            }
        }
    }
}
