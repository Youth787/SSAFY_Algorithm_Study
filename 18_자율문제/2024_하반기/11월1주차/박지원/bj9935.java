//백준 문자열 폭발 자바
//stack + 문자열

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= bombLength) {
                boolean flag = true;
                for (int j = 0; j < bombLength; j++) {
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bombLength; j++) stack.pop();
                }
            }

        }
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder answer = new StringBuilder();
            for (Character c: stack) answer.append(c);
            System.out.println(answer);
        }
    }
}
