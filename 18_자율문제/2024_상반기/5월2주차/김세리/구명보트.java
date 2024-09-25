// 처음 풀이 PriorityQueue이용, 효과적이지 않음. -> 투포인터 이용.

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 사람들의 몸무게를 오름차순으로 정렬
        int i = 0, j = people.length - 1; // i는 가장 가벼운 사람의 인덱스, j는 가장 무거운 사람의 인덱스
        int answer = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                // 두 사람의 몸무게 합이 무게 제한 이하인 경우, 두 사람을 함께 보트에 태움
                i++; // 가벼운 사람 인덱스 증가
            }
            // 무거운 사람은 항상 보트에 태움
            j--; // 무거운 사람 인덱스 감소
            answer++; // 사용된 보트의 수 증가
        }
        
        return answer;
    }
}
