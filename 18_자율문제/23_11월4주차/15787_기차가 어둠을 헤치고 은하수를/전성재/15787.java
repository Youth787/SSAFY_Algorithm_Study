import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Set<Integer> trainSet = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] train = new int[N + 1];
        int seat;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());
            int trainIdx = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1: {
                    seat = Integer.parseInt(st.nextToken());
                    train[trainIdx] |= 1 << seat;
                    break;
                }
                case 2: {
                    seat = Integer.parseInt(st.nextToken());
                    train[trainIdx] &= ~(1 << seat);
                    break;
                }
                case 3: {
                    train[trainIdx] <<= 1;
                    train[trainIdx] &= ((1 << 21) - 1);
                    break;
                }
                case 4: {
                    train[trainIdx] >>= 1;
                    train[trainIdx] &= ~1;
                    break;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            trainSet.add(train[i]);
        }
        System.out.println(trainSet.size());
    }
}
