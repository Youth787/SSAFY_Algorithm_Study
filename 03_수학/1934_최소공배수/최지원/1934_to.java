
import java.util.Arrays;
import java.util.Scanner;

//최소공배수
public class Main {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <=T ; tc++) {
			int [] nums = new int[2];
			nums[0] = sc.nextInt();
			nums[1] = sc.nextInt();
			Arrays.sort(nums);
			int gcd = nums[0]*nums[1]; //일단 최대로 나올 수 있는 값인 두 수의 곱 값을 넣기
			
			for (int i = 1; i<=nums[1] ; i++) {
				for (int j = 1; j <=nums[0]; j++) {
					if (nums[0]*i == nums[1]*j && gcd > nums[0]*i) {
						gcd = nums[0]*i;
						break;
					}
				}
			}
			
			System.out.println(gcd);
			
		
		} //test_Case

	} //main

} //class
