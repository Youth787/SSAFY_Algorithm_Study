package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수나누기게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int size = 1000001;
        int [] card = new int[N];
        int[] count = new int[size];
        boolean[] visit = new boolean[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            card[i] = Integer.parseInt(st.nextToken());
            visit[card[i]] = true;
        }

        for(int i : card){
            for(int j = i*2; j<size; j+=i){
                if(visit[j]) {
                    ++count[i];
                    --count[j];
                }
            }
        }
        for(int i : card){
            sb.append(count[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
