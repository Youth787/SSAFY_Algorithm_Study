import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class solve {
	
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	
		StringBuilder sb = new StringBuilder();
		//stringBuilder.append("문자열 ").append("연결");
		List<Integer> arr = new ArrayList<>();
	
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}

		Collections.sort(arr);
	
		for (int i = 0; i < N; i++) {
			sb.append(arr.get(i)).append('\n');
		}
		
		System.out.println(sb);
		sc.close();
	}
}