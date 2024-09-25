package SILVER;

import java.io.*;
import java.util.*;

public class 회의실배정 {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

//        // sort by end time
        Arrays.sort(schedule, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1]==o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count =0;
        int prev_end_time=0;
        for(int i=0; i<N; i++){
            if(prev_end_time <=schedule[i][0]){
                prev_end_time = schedule[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
