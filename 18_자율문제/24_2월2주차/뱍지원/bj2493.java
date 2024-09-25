import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static Stack<int[]> s;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (!s.isEmpty()) {
                if (s.peek()[1] >= top) {
                    System.out.print(s.peek()[0] + " ");
                    break;
                }
                s.pop();
            }
            if (s.isEmpty()) {
                System.out.print("0 ");
            }
            s.push(new int[] {i, top});
        }

    }

}

//https://moonsbeen.tistory.com/204
