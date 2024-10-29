package _20241025;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class _20210_파일탐색기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] files = new String[N];

        for (int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }

        // 커스텀 Comparator로 정렬
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0, j = 0;
                while (i < o1.length() && j < o2.length()) {
                    char charA = o1.charAt(i);
                    char charB = o2.charAt(j);

                    // 둘 다 숫자일 경우
                    if (Character.isDigit(charA) && Character.isDigit(charB)) {
                        String numA = extractNum(o1, i);
                        String numB = extractNum(o2, j);

                        int leadingZerosA = countLeadingZeros(numA);
                        int leadingZerosB = countLeadingZeros(numB);

                        // BigInteger를 사용하여 숫자 크기 비교 (빈 문자열인 경우 "0"으로 설정)
                        BigInteger bigNumA = new BigInteger(numA.substring(leadingZerosA).isEmpty() ? "0" : numA.substring(leadingZerosA));
                        BigInteger bigNumB = new BigInteger(numB.substring(leadingZerosB).isEmpty() ? "0" : numB.substring(leadingZerosB));
                        int result = bigNumA.compareTo(bigNumB);
                        if (result != 0) return result;

                        // 길이 비교 (사전식 순서로 동일한 경우)
                        if (numA.length() != numB.length()) return numA.length() - numB.length();

                        // 인덱스 이동
                        i += numA.length();
                        j += numB.length();
                    } 
                    // 둘 다 문자일 경우
                    else if (Character.isLetter(charA) && Character.isLetter(charB)) {
                        int result = compareLetter(charA, charB);
                        if (result != 0) return result;

                        // 인덱스 이동
                        i++;
                        j++;
                    } 
                    // 숫자와 문자가 섞인 경우: 숫자가 우선
                    else {
                        return Character.isDigit(charA) ? -1 : 1;
                    }
                }

                // 남은 길이 비교
                return o1.length() - o2.length();
            }
        });

        // 결과 출력
        for (String file : files) {
            System.out.println(file);
        }
    }

    // 숫자 추출
    private static String extractNum(String s, int idx) {
        StringBuilder num = new StringBuilder();
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            num.append(s.charAt(idx));
            idx++;
        }
        return num.toString();
    }

    // 숫자 문자열의 앞쪽에 있는 0의 개수 계산
    private static int countLeadingZeros(String s) {
        int count = 0;
        while (count < s.length() && s.charAt(count) == '0') {
            count++;
        }
        return count;
    }

    // 문자 비교: 대소문자 구분하며 대문자가 소문자보다 우선
    private static int compareLetter(char a, char b) {
        int lowerA = Character.toLowerCase(a);
        int lowerB = Character.toLowerCase(b);
        if (lowerA != lowerB) {
            return lowerA - lowerB;
        }
        return a - b; // 대문자가 소문자보다 우선하도록 비교
    }
}
