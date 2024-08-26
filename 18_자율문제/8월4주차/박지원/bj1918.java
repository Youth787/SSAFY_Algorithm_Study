//백준 후위표기식 자바
//stack, 우선순위 함수를 만들어주면 되는 간단한 문제

import java.io.*;
import java.util.*;

public class Main{
    private static int priority(char temp) {
        if (temp == '(') return 0;
        else if (temp == '+' || temp == '-') return 1;
        else return 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if ('A' <= temp && temp <= 'Z') answer.append(temp);
            else if (temp == '(') stack.add('(');
            else if (temp == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    answer.append(stack.pop());
                }
            } else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(temp)) {
                    answer.append(stack.pop());
                }
                stack.add(temp);
            }
        }
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        System.out.println(answer);
    }
}
