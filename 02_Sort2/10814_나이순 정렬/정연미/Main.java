import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// buffer 로 입력받고, stringbuilder 로 프린트 
// arrays.sort 메서드에서 comparator를 사용하여 정렬

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 회원 수를 입력받는다. 
		
		String[][] person = new String[T][2]; // 정보를 담을 2차원 배열을 만든다. 
		
		for(int i=0; i<T; i++) { // 회원 수만큼 돌면서 
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[i][0] = st.nextToken(); // 나이를 입력받는다. 문자열로 나이 입력받기.
			person[i][1] = st.nextToken(); // 이름을 입력받는다. 
		}
		
		Arrays.sort(person, new Comparator<String[]>() { // 2차원배열의 행 배열(1차원)을 가져온다. 
			@Override 
			public int compare(String[] o1 ,String[] o2) { // 행 배열(1차원)의 0번째 원소(나이)를 비교하여 오름차순 정렬한다.  
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); 
			}
		});
		
        // String builder를 사용하여 값을 프린트한다. 
		StringBuilder sb = new StringBuilder();
		for(String[] a : person) {
			sb.append(Integer.parseInt(a[0])+" "+a[1]+"\n");
		} System.out.println(sb);
	} // main end
}
