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

        Collections.sort(list,(a, b)->compareCustom(a,b));
        for(String pick : list) System.out.println(pick);
    }

    public static int compareCustom(String a, String b){
        int i=0; int j =0;
        while(i<a.length()&& j<b.length()){
            char charA = a.charAt(i);
            char charB = b.charAt(j);

            // 둘다 숫자일 경우
            if(Character.isDigit(charA)&&Character.isDigit(charB)){
                String numA = extractNum(a, i);
                String numB = extractNum(b, j);

                int leadingZerosA = countLeadingZeros(numA);
                int leadingZerosB = countLeadingZeros(numB);

                int compare = compareNum(numA.substring(leadingZerosA), numB.substring(leadingZerosB));
                if(compare!=0) return compare;
                if(numA.length()!=numB.length()) return numA.length()-numB.length();
                i+=numA.length();
                j+=numB.length();
            }

            // 둘다 문자일 경우
            else if(Character.isLetter(charA)&&Character.isLetter(charB)){
                int compareletter = compareLetter(charA, charB);
                if(compareletter!=0) return compareletter;
                i++;
                j++;
            }
            // 서로 자료형 다를 경우
            else return Character.isDigit(charA)?-1:1;
        }
        return a.length() - b.length();
    }
    public static String extractNum(String s , int idx){
        StringBuilder num = new StringBuilder();
        while(idx<s.length()&& Character.isDigit(s.charAt(idx))){
            num.append(s.charAt(idx));
            idx++;
        }
        return num.toString();
    }
    public static int compareNum(String a, String b) {
        // 숫자 문자열의 길이가 다르면 길이로 우선 비교
        if (a.length() != b.length()) {
            return a.length() - b.length();
        }
        // 길이가 같으면 문자열을 그대로 비교 (숫자 값으로 비교하는 효과를 줌)
        return a.compareTo(b);
    }

    public static int countLeadingZeros(String s) {
        int count = 0;
        while (count < s.length() && s.charAt(count) == '0') {
            count++;
        }
        return count;
    }
    public static int compareLetter(char a , char b){
        int A = Character.toLowerCase(a);
        int B = Character.toLowerCase(b);
        if(A!=B) return A-B;
        return a-b;
    }
}
