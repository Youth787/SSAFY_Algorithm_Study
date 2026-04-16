import java.io.*;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int s, t;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            pq.add(new int[]{s, t});
        }
        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(0);

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (room.peek() <= now[0]) room.poll();
            room.add(now[1]);
        }

        System.out.println(room.size());

    }
}
