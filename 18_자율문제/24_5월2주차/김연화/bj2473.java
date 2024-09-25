import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    // input 값이 들어오는 배열 선언
    static long[] arr;
    // 선택하는 3개의 인덱스 값을 넣을 배열 선언
    static int best[] = new int[3];
    // 세 포인터
    static int start, mid, end;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 투포인터 문제에서는 정렬이 필수적이다
        Arrays.sort(arr);

        // 투포인터의 응용으로 start는 for 문으로 하나씩 늘려가고, mid와 end를 각각 투포인터로 해결
        for (int i = 0; i < n - 2; i++) {
            start = i;
            mid = i + 1;
            end = n - 1;
            while (mid < end) {
                long sum = arr[start] + arr[mid] + arr[end];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    best[0] = start;
                    best[1] = mid;
                    best[2] = end;
                }
                if (sum == 0) {
                    break;
                } else if (sum > 0) {
                    end--;
                } else {
                    mid++;
                }
            }
        }
        System.out.println(arr[best[0]] + " " + arr[best[1]] + " " + arr[best[2]]);
    }
}
