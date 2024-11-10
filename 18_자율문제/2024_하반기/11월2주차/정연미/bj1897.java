package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1897 {
    static boolean[] visit;
    static String[] words;
    static int N;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String word = st.nextToken();
        words = new String[N];
        visit = new boolean[N];
        result = word;
        for(int i=0; i<N; i++) words[i] = br.readLine();

        DFS(word);
        System.out.println(result);
    }
    public static void DFS(String word){
        for(int i=0; i<N; i++){
            if(!visit[i] && words[i].length()==word.length()+1){
                if(check(word, words[i])){
                    if(result.length()<words[i].length()) result = words[i];
                    visit[i] = true;
                    DFS(words[i]);
                    visit[i] = false;
                }
            }
        }
    }

    public static boolean check(String word, String checkword){
        int i=0, j=0;
        boolean founddifference = false;
        while(i<word.length() && j<checkword.length()){
            if(word.charAt(i) != checkword.charAt(j)) {
                if (founddifference) return false;
                founddifference = true;
                j++;
            }else{
                i++;
                j++;
            }
        }
        return true;
    }
}
