//프로그래머스 단속카메라 자바
//정렬 구현

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
	    //도착점 기준 정렬
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
		
        int ans = 1;
        int end = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > end) {
                ans++;
                end = routes[i][1];
            }
        }
        return ans;
    }
}
