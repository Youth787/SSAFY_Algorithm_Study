import java.util.Scanner;

public class Main {

	static long num, result = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		num = input.nextLong();
		if(num <= 2) {
			result = num;
		}
		parametric();
		System.out.println(result);
	}

	private static void parametric() {
		long left = 1;
		long right = num;

		while (left < right) {
			long mid = (left >> 1) + (right >> 1);
			if (Math.pow(mid, 2) >= num) {
				result = mid;
				right = mid;
			} else {
				left = mid + 1;
			}
		}
	}
}


