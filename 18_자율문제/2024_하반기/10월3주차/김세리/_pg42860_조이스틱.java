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
        int minMove =n-1; // 끝까지 한 번에 가는 경우(이걸 기본으로 둔다)
        for(int i=0;i<n;i++){
            int next=i+1;
            // 연속된 A의 개수를 세준다
            while(next<n && name.charAt(next)=='A'){
                next++;
            }
            // A덩이를 건너뛰는 것과 아닌 것(n-1) 비교하여 적은 것을 선택
            
            // A덩이를 지나치지 않을때,
            // 1. 처음 시작을 오른쪽부터 하거나, 2. 시작을 왼쪽부터 하는 경우 두가지가 있다
            // 두 경우 모두: A덩어리 근처까지 이동-> 처음 시작점으로 다시 이동-> 반대방향으로 이동
            
            // 따라서 되돌아갈때 이동 수 가 적은 곳부터 먼저 가야 총 이동수를 줄일 수 있다
            // -> 이 부분을 계산한게 Math.min(i,n-next)이다
            minMove = Math.min(minMove, i+n-next+Math.min(i,n-next));
        }
        answer+=minMove;
        return answer;
    }
}
