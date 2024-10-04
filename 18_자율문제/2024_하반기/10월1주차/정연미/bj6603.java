package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj6603 {
    static int k;
    static int[] group;
    static boolean[] visit;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while(input.length()!=1){
            String[] arr = input.split(" ");
            k = Integer.parseInt(arr[0]);
            int[] ansset = new int[6];
            group = new int[k];
            visit = new boolean[k];
            for(int i=0; i<k; i++) group[i] = Integer.parseInt(arr[i+1]);
            ncr(0,0, ansset, visit);
            System.out.println();
            input = br.readLine();
        }
    }
    public static void ncr(int g_idx, int a_idx, int[] ansset, boolean[] visit) {
        if(a_idx==6) {
            for (int num : ansset) System.out.print(num + " ");
            System.out.println();
            return;
        }
        if(g_idx==k) return;

         for(int i=g_idx; i<group.length; i++){
            if(visit[i]) continue;
            ansset[a_idx] = group[i];
            visit[i] = true;
            ncr(i+1,a_idx+1,ansset,visit);
            visit[i] = false;
        }
    }
}
