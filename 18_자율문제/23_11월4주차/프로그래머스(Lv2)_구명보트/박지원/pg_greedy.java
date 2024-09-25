import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
      //정렬해서 최소+최대 더해가며 limit과 비교해줄것임
        Arrays.sort(people);

      //투포인터느낌???
      //시작점과, 끝점을 잡아서 둘이 더해간다
        int start = 0;
        int end = people.length - 1;
        while (true) {
            if (people[start] + people[end] > limit) { // 최소최대 더했는데 limit보다 크다면, 최대값 하나만 보트에 태움
                answer++;
                end--;
            } else { // 아니라면 둘이 보트에 태우고 start++, end--처리
                answer++;
                start++;
                end--;
            } 
          //만약 스타트와 엔드가 가리키고있는 사람이 한사람이라면 그냥 그 사람 보트에 태우고 정답만 올려주기
            if (start == end) answer++;
            if (start >= end) break; // 반복문 탈출
        }
        return answer;
    }
}
