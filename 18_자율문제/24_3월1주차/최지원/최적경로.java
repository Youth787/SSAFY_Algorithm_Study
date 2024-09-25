import java.util.Arrays;
import java.util.Scanner;
/*
 * 삼전 김대리 {회사 -> 냉장고 배달 n 명 방문 -> 집} 의 최단 경로's "이동거리" 출력
 * 좌표 사이 거리 계산 = |x1-x2| + |y1-y2| 
 */ 
public class Solution {
    static int n; // 고객 수
    static int ans; // 최단 경로의 이동 거리를 저장할 변수
    static int[][] arr; // 회사, 집, 고객의 집 좌표를 저장할 배열
    static int visited; // 방문한 고객 집의 상태를 비트마스크로 표현하는 변수
    static int[] sel; // 방문 순서를 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스의 수
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt(); // 고객의 수 입력 받기
            arr = new int[n+2][2]; // 회사0, 집1, 고객의 집 좌표를 저장할 배열 초기화
            ans = 1200; // 최단경로의 초기값 설정 (문제 조건에 따라 충분히 큰 값으로 설정)

            // 좌표 입력 받기 (i = 0 : 회사 -> i = 1 : 집 ->  i = 2 ~ n+1 고객 집 순)
            for(int i=0; i<n+2; i++) {
                arr[i][0] = sc.nextInt(); // x좌표
                arr[i][1] = sc.nextInt(); // y좌표
            }

            sel = new int[n]; // 고객 집 방문 순서를 저장할 배열 초기화
            visited = 0; // 방문한 고객 집 상태 초기화
            visit(0, visited); // 순열 생성 및 최단 경로 계산 시작
            System.out.println("#"+ tc + " "+ ans); // 결과 출력
        }
    }
 
    // idx: 현재 선택한 고객 집의 수, visited: 방문한 고객 집의 상태
    public static void visit(int idx, int visited) {
        //기저
        if (idx == n) { // 모든 고객 집을 방문한 경우
            int sum = 0; // 이동 거리 합계 계산
            // 선택된 방문 순서에 따라 이동 거리 계산
            for(int i=0; i<n; i++) {
                if(i==0) // 첫 고객 집 방문 시 회사에서의 이동 거리 계산
                    sum += Math.abs(arr[sel[i]][0]-arr[0][0])+Math.abs(arr[sel[i]][1]-arr[0][1]);
                else // 이전 고객 집에서 다음 고객 집까지의 이동 거리 계산
                    sum += Math.abs(arr[sel[i]][0]-arr[sel[i-1]][0])+Math.abs(arr[sel[i]][1]-arr[sel[i-1]][1]);
            }
            // 마지막 고객 집에서 집까지의 이동 거리 추가
            sum += Math.abs(arr[sel[n-1]][0]-arr[1][0])+Math.abs(arr[sel[n-1]][1]-arr[1][1]);
            // 최소 이동 거리 업데이트
            if(ans > sum) ans = sum;
            return;
        }
        
        // 재귀를 통한 모든 고객 집 방문 순서 생성
        for (int k = 0; k < n; k++) {
            if ((visited & (1<<k)) != 0) continue; // 이미 방문한 고객 집이면 스킵

            sel[idx] = k+2; // 방문 순서에 고객 집 번호 저장
            visit(idx+1, visited | 1<<k); // 다음 고객 집 방문을 위한 재귀 호출
        }
    }
}
