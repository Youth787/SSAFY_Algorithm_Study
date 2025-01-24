//백준 두 배열의 합 자바
//투포인터 (참고: https://lotuslee.tistory.com/30?category=963570)

import java.util.*;
import java.io.*;

public class Main {
    private static int t, n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> sumA = new ArrayList<>();
        ArrayList<Integer> sumB = new ArrayList<>();

        //부배열 구하기
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                sumA.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                sumB.add(sum);
            }
        }

        //부배열 정렬
        Collections.sort(sumA);
        Collections.sort(sumB);

        //이중배열 투 포인터
        int aSize = sumA.size();
        int bSize = sumB.size();

        //왼쪽부터 / 오른쪽부터 배열 진행
        long cnt = 0;
        int left = 0;
        int right = sumB.size() - 1;

        //정렬했기 때문에 왼쪽 + 오른쪽 합이 크면 오른쪽에서 <-, 작으면 왼쪽에서 ->
        while (left < aSize && right >= 0) {
            int sum = sumA.get(left) + sumB.get(right);

            //정렬했기 때문에 같은 수는 주루룩 같이 일렬로 있음
            //그럼 연속된 같은 수는 묶어서 A배열의 개 수 * B배열이ㅡ 개수를 더해 counting
            //ex a[1, 1, 1, 3, 4, 5] b[1, 3, 3, 4]일경우
            //Acnt = 연속된 1이 3개 = 3, Bcnt = 연속된 3이 2개 = 2
            //cnt += 3*2 (6가지경우이므로)
            if (sum == t) {
                int A = sumA.get(left);
                int B = sumB.get(right);
                long leftcnt = 0;
                long rightcnt = 0;
                while (left < aSize && sumA.get(left) == A) {
                    leftcnt++;
                    left++;
                }
                while (right >= 0 && sumB.get(right) == B) {
                    rightcnt++;
                    right--;
                }
                cnt += leftcnt * rightcnt;

            } else if (sum < t) left++;
            else right--;
        }
        System.out.println(cnt);
    }


}
