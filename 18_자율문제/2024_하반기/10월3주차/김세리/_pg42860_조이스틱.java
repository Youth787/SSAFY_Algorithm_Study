import java.util.*;
import java.io.*;

class Solution {    
    public int solution(String name) {
        int n = name.length();
        int answer=0;
        for(int i=0;i<n;i++){
            if(name.charAt(i)!='A'){
                // 다음 알파벳으로 이동하여 도달
                int forward = name.charAt(i)-'A';
                // 이전 알파벳으로 이동하여 도달
                int backward = 'Z'-name.charAt(i)+1;
                // 둘 중 적게 이동하여 도달할 수 있는 걸로 선택
                answer += Math.min(forward,backward);
            }
            
        }
        int minMove =n-1; // 끝까지 한 번에 가는 경우
        for(int i=0;i<n;i++){
            int next=i+1;
            // 연속된 A의 개수를 세준다
            while(next<n && name.charAt(next)=='A'){
                next++;
            }
            // A덩이를 건너뛰는 것과 아닌 것 비교하여 적은 것을 선택
            // i까지 이동 후 
            minMove = Math.min(minMove, i+n-next+Math.min(i,n-next));
        }
        answer+=minMove;
        return answer;
    }
}
