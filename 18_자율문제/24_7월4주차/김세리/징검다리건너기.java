import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int left=1;
        int right=200000000; // 문제에서 주어진 최대값
        int answer = 0;
        // 이분탐색 이용해서 가능한 최대수를 구한다
        while(left<=right){
            // mid: 건널 수 있는 니니즈 친구들 수 의미
            int mid = (left+right)/2;
            if(canCross(stones, k, mid)){
                answer = mid;
                left = mid +1;
            } else{
                right = mid -1;
            }
            
        }
        return answer;
    }
    
    private boolean canCross(int[] stones, int k, int mid){
        int consecutiveZeros = 0;
        
        for(int stone:stones){
            // mid명 만큼 건널때 0 미만이면 consecutiveZeros 수 증가
            // 0미만인 애들이 k개(최대 건널수 있는 디딤돌 수) 이상이면 이제 못건넌다
            if(stone-mid<0){
                consecutiveZeros++;
                if(consecutiveZeros>=k){
                    return false;
                }
            } else{
                consecutiveZeros=0;
            }
        }
        return true;
    }
    
}
