import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        
        int n = sequence.length;
        
        // 0 : [-1, 1, -1, 1, ...]
        // 1 : [1, -1, 1, -1, ...]
        // sequence와 pulse를 곱한 dp을 저장함
        List<long[]> dps = List.of(new long[n], new long[n]);
        
        dps.get(0)[0] = pulseMultiNumber(0, 0, sequence);
        dps.get(1)[0] = pulseMultiNumber(1, 0, sequence);
        answer = Math.max(dps.get(0)[0], dps.get(1)[0]);
        
        for(int i=1; i<n; i++){
            for(int k=0; k<2; k++){
                long cal = pulseMultiNumber(k, i, sequence);
                dps.get(k)[i] = Math.max(cal, dps.get(k)[i-1] + cal);
            }
            answer = Math.max(answer, Math.max(dps.get(0)[i], dps.get(1)[i]));
        }
        
        return answer;
    }
    
    private long pulseMultiNumber(int k, int i, int[] sequence){
        long t;
        if(i % 2 == 0) { // 짝수
            t = (k == 0) ? (sequence[i] * -1) : sequence[i];
        } else { // 홀수
            t = (k == 0) ? sequence[i] : (sequence[i] * -1);
        }
        return t;
    }
}

// https://ksb-dev.tistory.com/298
