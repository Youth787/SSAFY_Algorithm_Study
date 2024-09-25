package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// stack 자료구조


public class 탑 {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int[] result = new int[N];
            Stack<int[]> stack = new Stack<>();

            for (int i = 0; i < N; i++) {
                while (!stack.isEmpty() && stack.peek()[0] <= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result[i] = 0;
                } else {
                    result[i] = stack.peek()[1] + 1;
                }

                stack.push(new int[]{arr[i], i});
            }

            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
        }
    }

