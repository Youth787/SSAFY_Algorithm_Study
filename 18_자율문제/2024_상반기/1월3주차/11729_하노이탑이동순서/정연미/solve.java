package Algo_스터디.Jan_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이의탑 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2,N))-1).append("\n");
        hanoi(N,1,2,3);
        System.out.println(sb);
    }
    public static void hanoi(int N, int start, int mid, int end){
        if(N==1){
            sb.append(start+" "+end).append("\n");
            return;
        }
        hanoi(N-1, start, end, mid);
        sb.append(start+" "+end).append("\n");
        hanoi(N-1, mid, start, end);
    }
}
