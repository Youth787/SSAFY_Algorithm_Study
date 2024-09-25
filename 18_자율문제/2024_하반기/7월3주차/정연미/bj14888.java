package SILVER;

import java.io.*;
import java.util.*;

public class bj14888 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[] numbers;
    static int[] operator;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        operator = new int[4]; // + - x %

        for(int i=0; i<N; i++) numbers[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) operator[i] = Integer.parseInt(st.nextToken());

        DFS(numbers[0],1);

        System.out.println(max);
        System.out.println(min);
    }
    public static void DFS(int number, int idx){
        if(idx==N){
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        for(int i=0; i<4; i++){
            if(operator[i]>0) {
                operator[i]--;
                switch(i){
                    case 0 : DFS(number + numbers[idx],idx+1); break;
                    case 1 : DFS(number - numbers[idx],idx+1); break;
                    case 2 : DFS(number * numbers[idx],idx+1); break;
                    case 3 : DFS(number / numbers[idx],idx+1); break;
                }
                operator[i]++;
            }
        }
    }
}
bj14888
