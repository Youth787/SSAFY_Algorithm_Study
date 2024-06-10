import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        
        if (kmpSearch(s, p)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    
    // KMP 알고리즘을 이용한 문자열 검색
    public static boolean kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0; // text의 인덱스
        int j = 0; // pattern의 인덱스
        
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            
            if (j == pattern.length()) {
                return true; // pattern이 text의 부분 문자열로 발견됨
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return false; // pattern이 text의 부분 문자열로 발견되지 않음
    }
    
    // 부분 일치 테이블(LPS 배열) 생성
    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0; // 접두사와 접미사가 일치하는 길이
        int i = 1;
        
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
