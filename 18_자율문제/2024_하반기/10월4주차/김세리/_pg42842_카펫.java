import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalTiles = brown + yellow;
        
        for(int h=3;h<=Math.sqrt(totalTiles);h++){
            if(totalTiles%h == 0){
                int w = totalTiles/h;
                if((w-2)*(h-2)==yellow){
                    answer[0]=w;
                    answer[1]=h;
                    break;
                }
            }
        }
        return answer;
    }
}


// 내가 푼 풀이인데 왜 틀리는건지 잘 모르겠다
// class Solution {
//     public int[] solution(int brown, int yellow) {
//         int[] answer = new int[2];
        
//         int h=0;
//         int w = 0;
//         for(int i=0;i<brown*yellow;i++){
//             int j = brown/2+2-i;
//             if((i-2)*(j-2)==yellow){
//                 w=i; h=j;
//                 break;
//             }
//         }
//         answer[0] = Math.max(h,w);
//         answer[1] = Math.min(h,w);
//         return answer;
//     }
// }
