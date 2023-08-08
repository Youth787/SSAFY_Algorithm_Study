import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 소트인사이드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		while(N>0) {
			list.add(N%10);
			N= N/10;
		}
		
		Collections.sort(list); // 오름차순 정렬후
		Collections.reverse(list); // 뒤집기
		
		for(int n : list) {
			System.out.print(n);
		}
		
	}
}
