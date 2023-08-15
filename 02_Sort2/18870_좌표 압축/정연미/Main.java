import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

// hashset 특징 : 중복을 허용하지 않는다. 저장 순서를 유지하지 않는다. 
// stringbuilder 써야 시간초과 안난다. 

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 입력받을 숫자의 개수

		int[] array = new int[T]; // 숫자를 입력받을 원본 배열 생성
		HashSet<Integer> hashset = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기를 기준으로 읽기 위해
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(st.nextToken());
			array[i] = n;
			hashset.add(n);
		} // 입력 받음.
		
		int i=0;
		int[] sorted = new int[hashset.size()];
		for(int n : hashset) {
			sorted[i++] = n;
		}
		
		Arrays.sort(sorted);
		
		Map<Integer, Integer> map_sort = new HashMap<>();

		int value = 0;
		for (int key : sorted) {
			map_sort.put(key, value);
			value++;
		}

        StringBuilder sb = new StringBuilder();
		for (int n : array) {
			sb.append(map_sort.get(n) + " ");
		}System.out.println(sb);
	}// main end
}


