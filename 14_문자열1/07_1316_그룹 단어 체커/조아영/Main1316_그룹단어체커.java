import java.util.Scanner;

//참고: https://propercoding.tistory.com/166
public class Main1316_그룹단어체커 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//단어 개수
		int ans = n; //일단 다 정답이라고 시작, 만약 정답 아닌 거 발견하면 -1씩 할 것 
		for (int i=0; i<n; i++) {
			String str = sc.next();//단어 입력 받아 
			boolean[] arr = new boolean[26];//이미 쓴 알파벳인지 체크용 
			arr[str.charAt(0)-'a'] = true; //단어의 첫글자 체크 
			//System.out.println(str.charAt(0)-'a'); //첫글자 잘 뽑았는지 확인용 
			for (int j=1; j<str.length(); j++) {
				char ch = str.charAt(j);
				if (ch==str.charAt(j-1)) continue; //앞글자와 같으면 넘어가 
				else {
					if (arr[ch-'a']) {//앞글자와 다른 글자 나왔는데 그게 이미 쓴 거면 그룹단어아님 
						ans--; 
						break;
					}
					arr[ch-'a'] = true; //새로운 글자 나왔으니 이전 글자는 썼다고 표시  
				}
			}
		}
		System.out.println(ans);

	}
	
}
