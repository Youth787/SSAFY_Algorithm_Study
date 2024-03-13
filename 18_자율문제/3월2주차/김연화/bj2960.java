import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt(); //k번째 지우는 수
		
		boolean[] Num = new boolean[n+1];
		
		int count = 0;
		
		for(int i = 2; i<=n; i++) {
			Num[i]=true;
		}
		for(int i = 2; i<=n; i++) {
			for(int j = i; j<=n; j+=i) {
				if(!Num[j]) {
					continue;
				}
				Num[j]=false;
				count++;
				if(count==k) {
					System.out.println(j);
				}
			}
		}
	}
}
