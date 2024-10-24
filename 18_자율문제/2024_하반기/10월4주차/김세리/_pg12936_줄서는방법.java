import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> numbers = new ArrayList<>();
        // 각 자리에 선택 가능한 숫자의 조합 개수
        // 예) 첫 번째 자리 고정 -> 나머지 n-1자리에서 만들 수 있는 순열은 (n-1)!
        long[] factorial = new long[n+1];
        factorial[0] =1;
        // 숫자 리스트 역시 1부터 n까지 이기 때문에 numbers에 사용 가능한 숫자들 적어준다
        for(int i=1;i<=n;i++){
            factorial[i]=factorial[i-1]*i;
            numbers.add(i);
        }
        // 순열 인덱스는 0부터 시작하므로 하나를 빼준다
        k--;
        
        for(int i=0;i<n;i++){
            // 팩토리얼을 사용-> 남은 자리에서 만들 수 있는 순열의 개수는 (n-1-i)!
            // 숫자 idx를 구해서 numbers에서 선택
            int idx = (int) (k/factorial[n-1-i]);
            // 선택된 수는 answer에 넣어주고, numbers에서 지운다
            answer[i] = numbers.get(idx);
            numbers.remove(idx);
            // k값을 갱신하여 다음 자릿수를 구하러 간다
            k %= factorial[n-1-i];
        }
        return answer;
    }
}
