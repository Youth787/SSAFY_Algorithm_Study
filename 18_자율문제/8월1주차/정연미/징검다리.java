package GOLD;

public class programmers {

    public static int solution(int[] stones, int k) {
        int answer = 0;
        int max = 0;
        int size = stones.length;
        int min = 200000000;
        for (int i = 0; i < size; i++) {
            min = Math.min(min, stones[i]);
            max = Math.max(max, stones[i]);
        }
        int left = min;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (count >= k)
                    break;
                if (mid > stones[i]) {
                    count++;
                } else
                    count = 0;
            }
            if (count < k) {
                answer = mid;
                left = mid + 1;
            } else if (count >= k) {
                right = mid - 1;
            }
        }
        return answer;
    }
}
