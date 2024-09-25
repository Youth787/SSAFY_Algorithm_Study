package Algo_스터디.Jan_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지뢰찾기 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());
       for(int tc = 1; tc<=T; tc++){
           int ans =0;
           int N = Integer.parseInt(br.readLine());

           String input = br.readLine();
           int[] num = new int[N];
           for(int i=0; i<N; i++) num[i] = Character.getNumericValue(input.charAt(i));

           input = br.readLine();
           char[] bom = new char[N];
           for(int i=0; i<N; i++) bom[i] = input.charAt(i);

           // * 인 경우
           for(int i=0; i<N; i++) {
               if(bom[i]=='*'){
                   num[i] --;
                   ans++;
                   if(i>0) num[i-1]--;
                   if(i<N-1) num[i+1]--;
               }
           }

           // # 인 경우
           // 1) 왼쪽 끝
           if(bom[0]=='#'&& num[0]>0 && num[1]>0){
               num[0]--;
               num[1]--;
               ans++;
           }

           // 중앙
           for(int i=1; i<N-1; i++){
               if(bom[i]=='#'&&num[i-1]>0&&num[i]>0&&num[i+1]>0){
                   num[i-1]--;
                   num[i]--;
                   num[i+1]--;
                   ans++;
               }
           }

           // 오른쪽 끝
           if(bom[N-1]=='#'&& num[N-1]>0 && num[N-2]>0){
               num[N-1]--;
               num[N-2]--;
               ans++;
           }

           System.out.println(ans);
       }
    }
}
