package _20250217;

import java.util.*;
import java.io.*;

public class _1394_암호 {
	static final int MOD = 900528;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 문자 집합 입력
        String chars = br.readLine();
        int L = chars.length();  // 문자 집합 크기
        
        // 각 문자에 대한 인덱스 저장
        Map<Character, Integer> charIndex = new HashMap<>();
        for (int i=0;i<L;i++) {
            charIndex.put(chars.charAt(i), i);
        }
        
        // 암호 입력
        String password = br.readLine();
        long result = 0;

        // 암호 위치 계산
        for (int i=0;i<password.length();i++) {
            char currentChar = password.charAt(i);
            int index = charIndex.get(currentChar);
            
            // 앞의 모든 경우를 반영
            result = (result*L + (index+1)) % MOD;
        }
        
        System.out.println(result % MOD);
    }
}
