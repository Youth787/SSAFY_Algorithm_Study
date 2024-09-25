import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

//백준 11279 최대 힙 pq사용 (collections.reverseOrder()를 배웠다)
//최대힙을 직접 구현해보는 코드도 있다!
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.add(x);
            }
        }

        System.out.print(sb.toString());
    }
}
