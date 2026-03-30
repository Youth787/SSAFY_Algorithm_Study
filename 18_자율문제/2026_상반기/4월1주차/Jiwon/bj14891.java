import java.util.*;
import java.io.*;

public class bj14891 {
    static Deque<Integer> one, two, three, four;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        one = new ArrayDeque<>();
        two = new ArrayDeque<>();
        three = new ArrayDeque<>();
        four = new ArrayDeque<>();
        visited = new boolean[5];
        String temp = br.readLine();
        for (int i = 0; i < temp.length(); i++) one.addLast(temp.charAt(i) - '0');
        temp = br.readLine();
        for (int i = 0; i < temp.length(); i++) two.addLast(temp.charAt(i) - '0');
        temp = br.readLine();
        for (int i = 0; i < temp.length(); i++) three.addLast(temp.charAt(i) - '0');
        temp = br.readLine();
        for (int i = 0; i < temp.length(); i++) four.addLast(temp.charAt(i) - '0');
        for (int i = 0; i < 2; i++) { // 3시 기준으로 변경
            one.addLast(one.removeFirst());
            two.addLast(two.removeFirst());
            three.addLast(three.removeFirst());
            four.addLast(four.removeFirst());
        }
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            visited = new boolean[5];
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            turn(num, dir);
        }
        // 12시방향 구하기
        one.removeLast();
        two.removeLast();
        three.removeLast();
        four.removeLast();

        int answer = 0;
        if (one.removeLast() == 1) answer++;
        if (two.removeLast() == 1) answer += 2;
        if (three.removeLast() == 1) answer += 4;
        if (four.removeLast() == 1) answer += 8;

        System.out.println(answer);

    }

    static void turn(int num, int dir) {
        if (num == 1) {
            int temp = 0;
            visited[1] = true;
            if (!visited[2]) {
                for (int i = 0; i < 8; i++) {
                    int n = two.removeLast();
                    two.addFirst(n);
                    if (i == 3) temp = n;
                }
                if (one.peek() != temp) {
                    turn(2, dir * -1);
                }
            }
            if (dir == 1) one.addFirst(one.removeLast());
            else one.addLast(one.removeFirst());

        } else if (num == 2) {
            int temp = 0;
            visited[2] = true;
            if (!visited[1]) {
                temp = 0;
                for (int i = 0; i < 8; i++) {
                    int n = two.removeLast();
                    two.addFirst(n);
                    if (i == 3) temp = n;
                }
                if (one.peek() != temp) {
                    turn(1, dir * -1);
                }
            }

            if (!visited[3]) {
                temp = 0;
                for (int i = 0; i < 8; i++) {
                    int n = three.removeLast();
                    three.addFirst(n);
                    if (i == 3) temp = n;
                }
                if (two.peek() != temp) {
                    turn(3, dir * -1);
                }
            }
            if (dir == 1) two.addFirst(two.removeLast());
            else two.addLast(two.removeFirst());


        } else if (num == 3) {
            int temp = 0;
            visited[3] = true;
            if (!visited[2]) {
                temp = 0;
                for (int i = 0; i < 8; i++) {
                    int n = three.removeLast();
                    three.addFirst(n);
                    if (i == 3) temp = n;
                }
                if (two.peek() != temp) {
                    turn(2, dir * -1);
                }
            }

            if (!visited[4]) {
                temp = 0;
                for (int i = 0; i < 8; i++) {
                    int n = four.removeLast();
                    four.addFirst(n);
                    if (i == 3) temp = n;
                }
                if (three.peek() != temp) {
                    turn(4, dir * -1);
                }
            }
            if (dir == 1) three.addFirst(three.removeLast());
            else three.addLast(three.removeFirst());

        } else {
            visited[4] = true;
            if (!visited[3]) {
                int temp = 0;
                for (int i = 0; i < 8; i++) {
                    int n = four.removeLast();
                    four.addFirst(n);
                    if (i == 3) temp = n;
                }
                if (three.peek() != temp) {
                    turn(3, dir * -1);
                }
            }
            if (dir == 1) four.addFirst(four.removeLast());
            else four.addLast(four.removeFirst());
        }

    }

}