import java.io.IOException;
import java.util.Scanner;

public class bj1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		long sum = 0;
		int idx = 1;
		while(sum <= s) {
			sum += idx++;
		}
		System.out.println(idx - 2);
	}

}

//가장 큰n값을 구하는 방법 = 그냥 작은수부터 냅다 다 하나씩 더해가는 방법이 최고임
//int 와 long을 구별하는 걸 미리미리 하자!!! 실패떠서 알지말고!!
