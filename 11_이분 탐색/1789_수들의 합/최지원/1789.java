//이분탐색이랑 관련이 있나
import java.util.Scanner;

//문제: 서로 다른 n개의 자연수 합이 s이다. s를 알 때, 자연수 n의 최대값은?
//최대로 수를 쓰려면 1부터 쭉 더하면서 만드는 느낌으로 해야 할 듯
//S(1 ≤ S ≤ 4,294,967,295) 범위가 이래서 int말고 long으로 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		long sum = 0;//합을 더해주자
		long now = 0;//작은수부터 더해주기 위해.(지금 어떤 수를 더하고 있음 & 몇개의수를 더해줬음을 의미하는 변수)
		while (s >= sum) {//얼마나 더해줘야할지 모르니까 while문..
			// 만들어야 하는 수 s를 지금까지의 합 sum이 넘어서기 전까지 계속 돌림
			sum += ++now;//now를 +1해주고 sum에 더해줌. 지금까지 사용한 자연수는 now개.
		}
		//여기까지 구해졌다면, 지금  now는 어쨌는 내가 만들 수 있는, s에 제일 가까운 수.
		//그치만 완전히 같지는 않은 수일수도 있음 : 그렇다는건 넘치는 부분을 내가 지금까지 더한 자연수 중 하나를 다시 빼서 해결 가능할꺼임
		if (sum == s) System.out.println(now);
		else System.out.println(now-1);
	}//main
}//class
