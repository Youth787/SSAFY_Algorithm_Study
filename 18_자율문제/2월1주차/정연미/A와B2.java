package Algo_스터디.Fev_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2 {
    static int ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        String end = br.readLine();

        change(end, start);
        System.out.println(ans);
    }
    public static void change(String ed, String st){
        if(st.length()==ed.length()){
            if(st.equals(ed)) ans =1;
            return;
        }

        if(ed.charAt(ed.length()-1) == 'A'){
            change(ed.substring(0,ed.length()-1),st);
        }
        if(ed.charAt(0) == 'B'){
            StringBuilder sb1 = new StringBuilder(ed);
            String str = sb1.reverse().toString();
            change(str.substring(0,str.length()-1),st);
        }
    }
}
