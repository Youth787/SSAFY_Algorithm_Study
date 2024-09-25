package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자고르기 {
    static boolean[] visit;
    static int[] arr;
    static List<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());

        result = new ArrayList<>();
        visit = new boolean[N+1];

        for(int i=1; i<=N; i++){
            visit[i] = true;
            DFS(i,i);
            visit[i] = false;
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int num : result) System.out.println(num);
    }
    public static void DFS(int start, int target){
        if(!visit[arr[start]]){
            visit[arr[start]] = true;
            DFS(arr[start],target);
            visit[arr[start]] = false;
        }
        if(arr[start]==target) result.add(target);
    }
}
