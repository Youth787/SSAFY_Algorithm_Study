import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 1. 차량의 나가는 시점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int lastCamera = Integer.MIN_VALUE; // 마지막으로 카메라를 설치한 위치

        // 2. 각 차량의 경로를 확인하면서 카메라 설치
        for (int[] route : routes) {
            int entry = route[0]; // 차량이 들어오는 지점
            int exit = route[1];  // 차량이 나가는 지점

            // 3. 현재 차량이 기존 카메라로 단속되지 않으면 새로운 카메라 설치
            if (lastCamera < entry) {
                answer++;           // 카메라 하나 추가
                lastCamera = exit;  // 카메라를 차량이 나가는 지점에 설치
            }
        }

        return answer;
    }
}
