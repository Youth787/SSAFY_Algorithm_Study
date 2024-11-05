//프로그래머스 숫자 게임 자바
//투포인터느낌

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = -1;
        Arrays.sort(A);
        Arrays.sort(B);
        int cnt = 0;
        int idx1 = A.length - 1;
        int idx2 = B.length - 1;
        
        while (idx1 >= 0 && idx2 >= 0) {
            if (B[idx2] < A[idx1]) {
                idx1--;
                cnt++;
            } else if (B[idx2] == A[idx1]) {
                cnt++;
                idx1--;
            } else {
                idx1--;
                idx2--;
            }
        }
        return A.length - cnt;
    }
}
