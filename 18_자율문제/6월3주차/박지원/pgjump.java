//k칸 앞으로 점프 or (온거리) * 2 순간이동
//점프하면 k만큼 건전지가 달아
//n만큼 떨어져 있는 장소로 가고싶다. 건전지 사용량의 최소값을 구하라
//뒤에서 부터 /2 하면서 가는게 최고인듯 ?
//dp 일줄알고 가져온문젠데.. 너무쉬운문제였다.... 더 가면 dp로도 풀 문제였을듯

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while (n > 1) {
            int remain = n % 2;
            if (remain != 0) {
                ans++;
                n /= 2;
            } else {
                n /= 2;
            }
        }
        return ans + 1;
    }
}

