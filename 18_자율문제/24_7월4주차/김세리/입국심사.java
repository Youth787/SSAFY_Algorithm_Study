import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // left: 심사를 받는데 걸리는 최소 시간
        // right: 가장 느린 심사관이 모든 사람을 심사하는 경우
        long left =1;
        long right = Arrays.stream(times).max().getAsInt()*(long)n;
        long answer = right;
        while(left<=right){
            long mid = (left+right)/2;
            long total=0;
            
            // 각 심사관이 주어진 mid 시간동안 몇 명을 처리할 수 있는지 계산
            for(int time: times){
                total += mid/time;
            }
            // 계산한 인원이 n 이상이면 right를 줄이고
            // 아니면 left를 늘린다
            if(total>=n){
                answer = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return answer;
    }
}
