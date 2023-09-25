import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10798_세로읽기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[5]; //문자열 다섯줄 받아서 배열로 만듦 
		for (int i=0; i<5; i++) {
			String tmp = br.readLine();
			arr[i] = tmp; 
		}
		
		int idx = 0; 
		while (idx<15) { //최대 15글자이므로 
			for (int i=0; i<5; i++) {
				try { //글자 있으면 출력하고 없으면 건너뛰어 
					System.out.print(arr[i].charAt(idx));
				} catch (StringIndexOutOfBoundsException e) {
				}
			}
			idx++;
		}
		
	}

}
