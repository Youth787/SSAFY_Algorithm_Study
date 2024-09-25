package Algo_스터디.August_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// cnt 범위 long 설정 주의 

public class bj2143_retry {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrA = new int[n];
        for(int i=0; i<n; i++) arrA[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arrB = new int[m];
        for(int i=0; i<m; i++) arrB[i] = Integer.parseInt(st.nextToken());

        List<Integer> Asum = new ArrayList<>();
        List<Integer> Bsum = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++){
                sum+=arrA[j];
                Asum.add(sum);
            }
        }

        for(int i=0; i<m; i++) {
            int sum = 0;
            for(int j=i; j<m; j++){
                sum+=arrB[j];
                Bsum.add(sum);
            }
        }

        Collections.sort(Asum);
        Collections.sort(Bsum);

        long cnt =0;
        int leftpoint = 0;
        int rightpoint = Bsum.size()-1;

        while(leftpoint <Asum.size() && rightpoint >=0){
            int sum = Asum.get(leftpoint) + Bsum.get(rightpoint);
            if(sum ==T){

                int Apoint = Asum.get(leftpoint);
                int Bpoint = Bsum.get(rightpoint);
                long Acnt =0;
                long Bcnt =0;

                while(leftpoint <Asum.size() && Apoint == Asum.get(leftpoint)){
                    leftpoint++;
                    Acnt++;
                }

                while(rightpoint >=0 && Bpoint == Bsum.get(rightpoint)){
                    rightpoint--;
                    Bcnt++;
                }

                cnt+= Acnt * Bcnt;

            } else if(sum<T){
                leftpoint++;
            }else {
                rightpoint--;
            }
        }
        System.out.println(cnt);
    }
}
