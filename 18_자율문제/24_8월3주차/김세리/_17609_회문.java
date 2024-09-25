package _20240820;

import java.util.*;

public class _17609_회문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int tc=0;tc<T;tc++) {
			String str = sc.nextLine();
			System.out.println(checkPalindrome(str));
		}
	}//main
	
	private static int checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                // 회문이 아닌 경우: 한 글자를 삭제한 후 회문이 될 수 있는지 확인
                if (isPalindrome(str, left+1, right) || isPalindrome(str, left, right - 1)) {
                    return 1; // 유사 회문
                } else {
                    return 2; // 회문도 유사 회문도 아님
                }
            }
            left++;
            right--;
        }
        return 0; // 회문
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
