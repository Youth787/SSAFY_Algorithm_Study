import java.util.*;
import java.io.*;

//개어려버
public class Main {
    static int k;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        sb.append((int) Math.pow(2, k) - 1).append("\n");
        hanoi(k, 1, 2, 3);
        System.out.println(sb);
        

    }
    static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }

        //원반 n-1개 1->2 기둥으로 보내기
        hanoi(n - 1, from, to, via);

        //1개의 원반을 1->3 기둥으로 옮기기
        sb.append(from + " " + to + "\n");

        //원반 n-1개를 2->3 기둥으로 옮기기
        hanoi(n - 1, via, from, to);
    }
}

//잘설명해놓은 불로그라해서 봤는데 모르겡써...하..
//https://shoark7.github.io/programming/algorithm/tower-of-hanoi
