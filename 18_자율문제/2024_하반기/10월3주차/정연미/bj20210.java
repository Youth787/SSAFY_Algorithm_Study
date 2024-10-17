package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Character.isDigit()
// Character.isLetter()
// Long.compare // Integer.compare // 결과 -1,0,1
// toLowerCase // toUpperCase

public class bj20210 {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String input = br.readLine();
            list.add(input);
        }

        Collections.sort(list,(a,b)->compareCustom(a,b));
        for(String pick : list) System.out.println(pick);
    }
    public static int compareCustom(String a, String b){
        int i =0; int j =0;
        while(i<a.length()&&j<b.length()){
            char charA = a.charAt(i);
            char charB = b.charAt(j);

            //둘다 숫자인경우
            if(Character.isDigit(charA)&&Character.isDigit(charB)){
                String numA = extractNum(a,i);
                String numB = extractNum(b,j);
                int numcompare = compareNum(numA,numB);
                if(numcompare!=0) return numcompare;
                if(numA.length()!=numB.length()) return numA.length()-numB.length();
                // 동일한 문자열이라면?
                i+=numA.length();
                j+=numB.length();
            }
            //둘다 문자인경우
            else if(Character.isLetter(charA)&&Character.isLetter(charB)){
                int charcompare = compareLetter(charA, charB);
                if(charcompare!=0) return charcompare;
                i++;
                j++;
            }
            // 자료형이 다른경우 숫자가 먼저온다.
            else return Character.isDigit(charA)?-1:1;
            // 문자열이 모두 끝났는가?
        }
        return a.length()-b.length();
    }

    public static String extractNum(String s, int index){
        StringBuilder sb = new StringBuilder();
        while(index<s.length()&&Character.isDigit(s.charAt(index))){
            sb.append(s.charAt(index));
            index++;
        }
        return sb.toString();
    }

    public static int compareNum(String a , String b){
        // 자바에서 형변환 할 수 있는 함수는 parse와 valueOf가 있다.
        long valA = Long.parseLong(a);
        long valB = Long.valueOf(b);
        return Long.compare(valA,valB);
    }

    public static int compareLetter(Character a, Character b){
        char lowerA = Character.toLowerCase(a);
        char lowerB = Character.toLowerCase(b);
        if(lowerA!=lowerB) return lowerA-lowerB;
        return a-b;
    }
}
