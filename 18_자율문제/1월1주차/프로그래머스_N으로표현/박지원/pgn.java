import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> result = new ArrayList<>();

        for (int i = 0 ; i < 8; i++) {
            result.add(new HashSet<>());
        }
        result.get(0).add(N); // N을 1개만 사용할 경우, N 자신만 표현 가능

        for (int i = 0; i < 8; i++) {
            Set<Integer> currentResult = result.get(i);
            // 1. N을 (i + 1)번 이어붙인 경우
            currentResult.add(Integer.parseInt(String.valueOf(N).repeat(i + 1)));

            // 2. 이전 단계의 결과를 서로 사칙연산한 결과
            // [N을 1개 사용한 경우] union [(i + 1) - 1개 사용한 경우]
            // [N을 2개 사용한 경우] union [(i + 1) - 2개 사용한 경우]
            // ...
            for (int j = 0; j < i; j++) {
                for (int case1 : result.get(j)) {
                    for (int case2 : result.get(i - 1 - j)) {
                        currentResult.add(case1 + case2);
                        currentResult.add(case1 - case2);
                        currentResult.add(case1 * case2);
                        if (case2 != 0) {
                            currentResult.add(case1 / case2);
                        }
                    }
                }
            }

            if (currentResult.contains(number)) {
                return i + 1;
            }
        }

        return -1;
    }
}
// 출처: https://praetoriani.tistory.com/27 [SilentWalk:티스토리]
