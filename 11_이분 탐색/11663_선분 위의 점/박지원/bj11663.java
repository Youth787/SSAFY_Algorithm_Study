import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class bj11663 {

    static int n, m;
    static Long[] dot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dot = new Long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dot[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(dot);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int res = bSearch(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
    //x, y 둘을 따로 돌리는 것이 포인트인 문제!!
    static int bSearch(int x, int y) {
        int st = 0;
        int end = n - 1;

        while (st <= end) { // 스타트가 끝보다 작거나 같을때만 돌아가
            int mid = (st + end) / 2; // 중간값 구해주고
            if (dot[mid] > y) // dot[mid]가 y보다 크다면
                end = mid - 1; // 끝 값이 변해야겠지?
            else // y보다 작다면
                st = mid + 1; // 첫 값이 변해야겠지?
        }
        int endIdx = end + 1; // 반복문 끝나면 마지막 인덱스를 저장해준다.

        st = 0;
        end = n - 1; // 첫값, 끝값 초기화 시켜주기
        while(st <= end) {
            int mid = (st + end) / 2;

            if (dot[mid] < x)
                st = mid + 1;
            else
                end = mid - 1;
        }
        int stIdx = st;
        return endIdx - stIdx;
    }
}


//https://easybrother0103.tistory.com/92
