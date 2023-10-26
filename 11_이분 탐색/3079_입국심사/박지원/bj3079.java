import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class bj3079 {

    static int n;
    static long m, max;
    static int[] arr;
    static long result = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        max = arr[n - 1]; // 시간의 최대값 구하려고 변수 설정

        solve();

        System.out.print(result);
    }
    static void solve() {
        long low = 0;
        long high = m * max; // 시간 최대값은 제일 오래걸리는줄(max) * 인원수(m)
      // 시간의 범위는 0~ high라고 정의 가능하다!
      
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (long index: arr) {
                long count = mid/index; // 한 게산대에서 맡을 수 있는 사람의 수

                if (sum >= m) break;

                sum += count; // 처리할 수 있는 사람을 더해준다.
            }
            if (sum >= m) {
                high = mid - 1;
                result = Math.min(mid, result);
            } else {
                low = mid + 1;
            }
        }
    }
}
// 이진 탐색 -> 시간을 중심으로 탐색
// 해당 시간일 때 최대 몇 명의 사람을 입국 심사대에서 통과 시킬 수 있는가를 중점으로 이진탐색을 진행
// 만약 mid초일 때, m명 이상의 사람을 해당 시간에 입국 심사대에서 보낼 수 있음 -> 시간 탐색범위를 0 ~ mid-1
// 만약 mid초 일 때, m-1 이하의 사람을 해당 시간에 입국 심사대에서 보낼 수 있음 -> 시간 탐색 범위를 mid+1 ~ high
// 처음 low는 0으로 설정, high는 각 입국심사대에서 걸리는 시간의 최대값(t) * 심사 받으려는 사람의 수(m)
// https://developer-ellen.tistory.com/98
// https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-3079-%EC%9E%90%EB%B0%94-java-%EC%9E%85%EA%B5%AD-%EC%8B%AC%EC%82%AC
