package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[H+1];
        int[] up = new int[H+1];

        for(int i=0; i<N; i+=2) {
            down[Integer.parseInt(br.readLine())]++;
            up[Integer.parseInt(br.readLine())]++;
        }

        for(int i=H-1; i>0; i--){
            down[i]+=down[i+1];
            up[i] +=up[i+1];
        }

        int count =0;
        int min = N;
        for(int h=H; h>=1; h--){
            if(down[h]+up[H-h+1]<min){
                count = 1;
                min = down[h]+up[H-h+1];
            }else if(down[h]+up[H-h+1]==min){
                count++;
            }
        }

        System.out.println(min + " " + count);

    }
}
