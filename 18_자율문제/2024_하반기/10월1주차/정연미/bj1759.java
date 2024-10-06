package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1759 {
    static char[] group;
    static int L,C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[] ansgroup = new char[L];
        boolean[] visit = new boolean[C];

        group = br.readLine().replace(" ","").toCharArray();
        Arrays.sort(group);
        ncr(0,0,ansgroup,visit);
    }
    public static void ncr(int idx, int sidx,char[] ansgroup, boolean[] visit){
        if(sidx==L){
            if(check(ansgroup)) {
                // 정렬 후 출력
                Arrays.sort(ansgroup);
                for(char num : ansgroup) System.out.print(num);
                System.out.println();
            }
            return;
        }
        if(idx==C) return;

        for(int i=idx; i<C; i++){
            if(visit[i]) continue;
            ansgroup[sidx] = group[i];
            visit[i] = true;
            ncr(i+1, sidx+1,ansgroup,visit);
            visit[i] = false;
        }
    }
    public static boolean check(char[] ansgroup){
        int novelcnt =0;
         int notnovelcnt=0;
         for(int i=0; i<ansgroup.length; i++){
             if(ansgroup[i]=='a'||ansgroup[i]=='e'||ansgroup[i]=='i'||ansgroup[i]=='o'||ansgroup[i]=='u') novelcnt++;
             else notnovelcnt++;
         }
         if(novelcnt>=1&&notnovelcnt>=2) return true;
        return false;
    }
}
