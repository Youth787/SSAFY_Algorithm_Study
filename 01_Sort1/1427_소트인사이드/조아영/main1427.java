import java.util.Arrays;
import java.util.Scanner;

public class main1427 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int[] arr = null;
		
		//몇자리 수인지에 따라서 자리마다 숫자 구해서 그걸 정렬하는 방식으로 풀려고 했는데 자리수가 너무 커서 노가다하려다 포기함... 
		//뭔가 더 효율적인 방법이 있을 것 같지만 혼자 힘으로는 찾지 못했음... 
		
		if (num<10) {
			
			arr = new int[1];
			arr[0]=num;
			
		} else if (num<100) {
			
			arr = new int[2];
			arr[0]= num/10;
			arr[1]=num%10;
			Arrays.sort(arr); //소트는 최소->최대값 순이므로 역순으로 뽑아줘야함 
			
		} else if (num<1000) {
			
			arr = new int[3];
			arr[0]= num/100;
			arr[1]=(num%100)/10;
			arr[2]=(num%100)%10;
			Arrays.sort(arr);			
			
		} else if (num<10000) {
			
			arr = new int[4];
			arr[0] = num/1000;
			arr[1] = (num%1000)/100; 
			arr[2] = (num%1000)%100/10;
			arr[3] = (num%1000)%100%10;
			Arrays.sort(arr);	
		
		} else if (num<100000) {
			
		} else if (num<1000000) {
			
		} else if (num<10000000) {
			
		} else if (num<100000000) {
			
		} else if (num<1000000000) {
			
		} else if (num==1000000000) {
			arr = new int[1];
			arr[0]=num;
		}
		
		for (int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]);
		}
			
		
//		2143/1000 =2
//		(2143%1000)/100 =1
//		((2143%1000)%100)/10 4
//		((2143%1000)%100)%10 3
		
		
		
	}
	
}
