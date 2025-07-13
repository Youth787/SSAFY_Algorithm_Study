import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') s.add('(');
            else {
                s.pop();
                if (str.charAt(i - 1) == ')') {
                    answer++;
                } else answer += s.size();
            }
        }
        System.out.println(answer);
    }

}
