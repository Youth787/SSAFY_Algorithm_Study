package m2w2;
import java.io.*;
import java.util.*;


//1288. 새로운 불면증 치료법
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18_yw6I9MCFAZN
public class Solution1288 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[10];
			int ans = 1;
			
			int num = n;
			while (num>=10) {
				int remains = num%10; //num의 1의 자리 
				nums[remains]++;
				num = num/10;
			}
			nums[num]++; //마지막 남은 숫자도 표시 
			//System.out.println(Arrays.toString(nums));
			
			int cnt = 0;
			for (int i=0; i<10; i++) {
				if (nums[i]==0) cnt++; 
			}
			//만약에 cnt>0이면 
			ans++; //양 한 번 더 세어야 하니까 일단 센 횟수 +1 해주고 
			num = n; //다시 원래 숫자로 되돌려서 
			num = num << 1; //두배로 만들어 

			//그리고 또 위의 과정을 거쳐 (미구현...) 
		
			System.out.printf("#%d %d",t,ans);
		}
	}
}
