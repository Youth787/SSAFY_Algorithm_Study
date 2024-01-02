import java.util.Set;
import java.util.TreeSet;
/*
 * 숫자 N을 사용한 "사칙연산"으로 number를 표현할 때 N 사용횟수의 최솟값
 * 8번보다 많이 N을 사용한 경우에는 -1
 * N이 1개일때, 2개일때 만들 수 있는 숫자의 경우의 수를 각각 구한다
 * 순서가 다른 연산으로 중복값이 발생하지 않도록 중복 제거 자료구조를 활용
 * 참고: https://velog.io/@doxxx93/programmers-pracice-42895
 */

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        Set <Integer> [] dp = new Set[9];
        for (int i = 1; i <= 8; i++){
            //각각의 dp를 TreeSet으로
            dp[i] = new TreeSet<>();
        }

        for (int i = 1; i <= 8; i++){
            dp[i].add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }//단순히 N을 이어 붙인 형태들을 먼저 dp에 저장

        for (int i = 1; i <= 8; i++){ //전체 dp를 채우는 for문
            for (int j = 1; j < i; j++){ //i의 이전 숫자들을 활용하기 위한 for문
                for (int k : dp[j]){ //i 이전의 숫자들의 dp값 TreeSet 안에 들어있는 숫자들 = N j개로 만들 수 있는 숫자들
                    for (int l : dp[i-j]){ //i-j로 만들 수 있는 숫자들
                        dp[i].add(k+l);
                        dp[i].add(k-l);
                        dp[i].add(k*l);
                        if (l != 0){
                            dp[i].add(k/l);
                        }
                    }
                }
            }
        }
        
        for (int i = 1; i <= 8; i++){
            if (dp[i].contains(number)){
                answer = i;
                break;
            }
        } //number가 N을 최대 8개까지 사용하여 만들 수 있는 숫자인지를 contains로 확인
        
        
        return answer;
    }
}
