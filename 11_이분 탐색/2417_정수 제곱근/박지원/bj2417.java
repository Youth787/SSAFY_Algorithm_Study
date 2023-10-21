import java.util.Scanner;

//이분탐색 활용
public class bj2417 {
    static long n;
    static long result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        long start = 0;
        long end = n;
        bSearch();

        System.out.println(result);
    }
    static void bSearch() { // start, mid, end를 활용해서 절반씩 나누어서 이분탐색하자! (기본)
        long start = 0;
        long end = n;
        while(start <= end) {
            long mid = (start + end) / 2;
            if (n <= Math.pow(mid, 2)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;

            }

        }
    }
}

//이분탐색 안쓰고 풀었을 때 코드
//이게 더 간편한 코드지만 이분탐색 공부하기 위한 문제였으니 위 처럼 풀자!
// import java.util.Scanner;

// public class Main {
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		long n = sc.nextLong();
// 		long num = (long) Math.sqrt(n);
// 		if (num*num < n) num++;
// 		System.out.println(num);
// 	}
// }



