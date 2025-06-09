//백준 오큰수 자바
//stack

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            data[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++){

            while(!s.isEmpty() && data[s.peek()] < data[i]){
                data[s.pop()] = data[i];
            }

            s.add(i);
        }

        while(!s.isEmpty())
            data[s.pop()] = -1;

        for(int i = 0; i < n; i++)
            sb.append(data[i]).append(" ");

        System.out.println(sb);
    }
}
