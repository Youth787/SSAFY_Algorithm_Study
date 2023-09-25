import java.util.Scanner;

public class Main20154_승자누구 {
	
	static int ans = 0; 
	
	public static void main(String[] args) {
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String number = "32123333113133122212112221";
		char[] apb = alphabet.toCharArray(); //알파벳 배열 
		int[] apbnum = new int[26]; //알파벳별 획수 배열 
		for (int i=0; i<26; i++) {
			apbnum[i] = number.charAt(i)-'0';
		}
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); 
		char[] strarr = str.toCharArray(); //주어진 문자열 배열 
		int n = str.length(); //위의 배열 사이즈 
		int[] strnum = new int[n]; //위의 문자열의 획수 담을 배열 
				
		for (int i=0; i<n; i++) {
			for (int j=0; j<26; j++) {
				if (strarr[i]==apb[j]) { //해당 알파벳의 획수 찾아서 배열에 담음
					strnum[i]=apbnum[j];
				}
			}
		}

		findWinner(strnum); //재귀로 답을 찾아보자 
		
	} //main
	
	static void findWinner(int[] arr) {
		
		int length = arr.length; //배열 반씩 줄여가며 체크해야 해서 확인 편하려고
		int half = length/2; 
		
		if (length==1) { //배열 마지막 한칸 남았으면 정답 출력하고 리턴 
			if (arr[0]%2==1) System.out.println("I'm a winner!");
			else System.out.println("You're the winner?");
			return;
			
		} else { //마지막 아니면 여기로 와 
			
			int[] tmp = {};
			if (length%2==0) { //배열 칸수가 짝수개인지 홀수개인지에 따라서 계산 
				tmp = new int[half]; 
				int idx=0; 
				for (int i=0; i<half; i++) {
					tmp[i]=(tmp[i]+arr[idx++]+arr[idx++])%10;
				}
			} else {
				tmp = new int[half+1]; 
				int idx=0; 
				for (int i=0; i<half; i++) {
					tmp[i]=(tmp[i]+arr[idx++]+arr[idx++])%10;
				}
				tmp[half]=arr[length-1];
			}
			
			//한번 계산한 거 가지고 또 해 
			findWinner(tmp);
			
		} //else
		
	} //findWinner

} //class 
