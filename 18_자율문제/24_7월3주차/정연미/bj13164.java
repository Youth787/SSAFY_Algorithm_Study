package GOLD;

import java.io.*;
import java.util.*;

public class bj13164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result =0;

        int[] line = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) line[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> diff = new ArrayList<>();
        for(int i=1; i<N; i++) diff.add(line[i]-line[i-1]);
        Collections.sort(diff);

        for(int i=0; i<N-K; i++)
            result += diff.get(i);

        System.out.println(result);
    }
}
