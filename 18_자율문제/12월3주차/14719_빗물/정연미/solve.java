package Algo_스터디.Dec_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] height = new int[W];
        for(int i=0; i<W; i++) height[i] = Integer.parseInt(st.nextToken());
        int ans =0;

        for(int i=1; i<W-1; i++){
            int left = 0;
            for(int j=0; j<i; j++){
                if(height[j]>height[i]) left = Math.max(left,height[j]);
            }
            int right = 0;
            for(int j=i+1; j<W; j++){
                if(height[j]>height[i]) right = Math.max(right,height[j]);
            }

            int water = Math.min(left,right);
            if(water !=0) ans += water - height[i];
        }
        System.out.println(ans);
    }
}
