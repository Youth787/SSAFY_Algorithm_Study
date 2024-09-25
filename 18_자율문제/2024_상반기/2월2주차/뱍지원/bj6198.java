import java.io.*;
import java.util.*;

public class Main {
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!s.isEmpty()) {
                if (s.peek() <= h) {
                    s.pop();
                } else break;
            }
            answer += s.size();
            s.push(h);
        }


        System.out.println(answer);




    }




}

//https://meojiktard.tistory.com/17
