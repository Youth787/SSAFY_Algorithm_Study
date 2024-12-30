//프로그래머스 입국심사 자바
//이분탐색

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long mid;
        long cnt;
        long answer = right;

        while (left <= right) {
            mid = (left + right) / 2;
            cnt = 0;
            for (int time: times) {
                cnt += mid / time;
            }
            if (cnt >= n) {
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;

        }
        return answer;
    }
}
