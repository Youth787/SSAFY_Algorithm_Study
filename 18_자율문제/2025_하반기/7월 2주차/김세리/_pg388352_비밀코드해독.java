import java.util.*;
import java.io.*;

class Solution {
    static List<int[]> possiblePW = new ArrayList<>();
    public int solution(int n, int[][] q, int[] ans) {
        
        int answer = 0;
        
        for(int first=1;first<=n-4;first++){
            for(int second=first+1;second<=n-3;second++){
                for(int third=second+1;third<=n-2;third++){
                    for(int fourth=third+1;fourth<=n-1;fourth++){
                        for(int fifth=fourth+1;fifth<=n;fifth++){
                            if(chk(first,second,third,fourth,fifth,q,ans)){
                                answer++;
                                // System.out.println(first+" "+second+" "+third+" "+fourth+" "+fifth);
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
    static boolean chk(int first,int second,int third,int fourth,int fifth,int[][] q,int[] ans){
        int cnt;
        for(int i=0;i<ans.length;i++){
            cnt=0;
            if(q[i][0]==first || q[i][0]==second || q[i][0]==third || q[i][0]==fourth || q[i][0]==fifth) cnt++;
            if(q[i][1]==first || q[i][1]==second || q[i][1]==third || q[i][1]==fourth || q[i][1]==fifth) cnt++;
            if(q[i][2]==first || q[i][2]==second || q[i][2]==third || q[i][2]==fourth || q[i][2]==fifth) cnt++;
            if(q[i][3]==first || q[i][3]==second || q[i][3]==third || q[i][3]==fourth || q[i][3]==fifth) cnt++;
            if(q[i][4]==first || q[i][4]==second || q[i][4]==third || q[i][4]==fourth || q[i][4]==fifth) cnt++;
            if(cnt!=ans[i]) {
                return false;
            // } else{
                // System.out.println("cnt: "+cnt+" i: "+i);
            }
        }
        
        return true;
    }
}
