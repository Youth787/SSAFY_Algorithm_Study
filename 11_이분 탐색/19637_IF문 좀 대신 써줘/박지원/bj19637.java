import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


//스캐너 쓰고 바로바로 sysout으로 출력하면 시간초과가 뜸
//백준문제 풀땐 걍 br, sb를 쓰기로 맘먹음
//처음에는 입력값을 다 배열로 미리 받아놓고 생각해서 조금 어려웠음
//그냥 입력값 하나 받고 처리하고 하나받고 처리하는 형식이 오히려 더 쉬울 수 있따!
public class bj19637 {

    static int n, m;
    static String[][] name;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken()); // 칭호갯수
        m = Integer.parseInt(st.nextToken()); // 캐릭터들의 수
        name = new String[n][2]; // 칭호 이름과 최대값을 이차원배열로 함께 가져가기

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name[i][0] = st.nextToken();
            name[i][1] = st.nextToken();
        }

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n - 1;
            int mid = (start + end) / 2;
            while (start <= end) {
                mid = (start+ end) / 2;

                int target = Integer.parseInt(name[mid][1]);
                if (target < number)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            sb.append(name[start][0]).append("\n");
        }
        System.out.print(sb);

    }
}
