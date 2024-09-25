package ALGO_STUDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 문자열잘라내기 {
    static int cnt = 0;
    static char[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        // 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] arr = new String[M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (i == 0) arr[j] = String.valueOf(s.charAt(j));
                else arr[j] += String.valueOf(s.charAt(j));
            }
        }


        for (int i = 1; i < N ; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < M; j++) {
                set.add(arr[j].substring(i));
            }
            if(set.size()==M) cnt++;
            else break;
        }
        System.out.println(cnt);
    }
}

/*
Stirng으로 형변환하는 메서드 

1. String.valueOf()
: null값이 들어가면 null 반환 
2. Object.toString()
: null 값이 들어가면 오류. 

*/

/*
문자열 자르기 
substring

ex)
String str = "Hello";

System.out.println(str.substring(2)); // "llo"        
System.out.println(str.substring(5)); // ""        
System.out.println(str.substring(-1)); // StringIndexOutOfBoundsException        
System.out.println(str.substring(6)); // StringIndexOutOfBoundsException

*/
