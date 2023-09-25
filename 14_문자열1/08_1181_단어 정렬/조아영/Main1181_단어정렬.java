import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main1181_단어정렬 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.parallelSort(arr,new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length()==s2.length()) { //단어 길이가 같을 경우 
					return s1.compareTo(s2); //단어 사전순 정렬 
				} else { //길이가 다른 경우 
					return s1.length() - s2.length();
				}
			}
		});
		
//		for(int i=0; i<N; i++) {
//			sb.append(arr[i]).append('\n');
//		}
//		System.out.println(sb);
		
		System.out.println(arr[0]); 
		for (int i=1; i<N; i++) { //0은 위에서 따로 빼고 1부터 시작 
			if (!arr[i].equals(arr[i-1])) { //앞번호와 중복 단어 아니면 
				System.out.println(arr[i]);
			}
		}
		
	}
	

}
