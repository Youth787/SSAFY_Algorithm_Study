import java.util.Scanner;

//문제 : 정수가 주어지면, 그 수의 정수 제곱근을 구하는 프로그램.
//이것도 범위가 뭔가 커보이기 때문에 long으로 설정. (0 ≤ n < 263)
//문제랑 다르게 출력에는 "첫째 줄에 q2 ≥ n인 가장 작은 음이 아닌 정수 q를 출력"이라고 써있음
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long q = (long)Math.sqrt(n);
		if (q*q < n) q+=1;
		System.out.println(q);
	}//main
}//class
