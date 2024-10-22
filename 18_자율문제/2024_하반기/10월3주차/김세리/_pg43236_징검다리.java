import java.util.*;
import java.io.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left=1; int right=distance;
        int answer=0;
        
        while(left<=right){
            int mid=(right+left)/2;
            int cnt=0;
            // 이전 바위 위치(시작은 시작점0부터)
            int prev=0;
           
            for(int rock: rocks){
                // 돌사이 거리가 mid보다 작으면 깨야함
                if(rock-prev<mid){
                    cnt++;
                } else {
                    // 깨지 않아도 될 경우 prev 현재돌로 업데이트
                    prev=rock;
                }
            }
            // 마지막 돌과 도착지점 사이도 계산, 깨야할 경우 cnt추가
            if(distance-prev<mid){
                cnt++;
            }
            // 돌 개수가 주어진 것보다 많이 깨야하면 right 업데이트
            if(cnt>n){
                right = mid-1;
            } else{
                // 너무 적거나 같으면 left 업데이트
                answer=mid;
                left=mid+1;
            }
        }
        
        return answer;
    }
}
