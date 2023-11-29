import java.io.*;
import java.util.LinkedList;
import java.util.*;
import java.util.StringTokenizer;

//비트연산자 너무 어렵고!!!!!!!!!!!!!!!
//비트연산자만 알면 쉬운 문제!
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Set<Integer> trainSet = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] train = new int[n + 1];
        int seat;
        for (int i = 0; i < m; i++) {
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
        for (int i = 1; i<= n; i++) {
            trainSet.add(train[i]);
        }
        System.out.println(trainSet.size());
    }

}

//https://today-retrospect.tistory.com/150
