import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class main18870_좌표압축 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
			
		int[] arr = new int[N];
		int[] sortArr = new int[N]; //정렬해서 담을 배열 
		HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>(); 
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i=0; i<N; i++) {
			sortArr[i]=arr[i]=Integer.parseInt(st.nextToken());	
		}
		
		//좌표 압축 : 현재 숫자보다 작은 서로 다른(=중복X) 숫자의 개수
		//중복 제외하고 큰 숫자부터 랭크 매기기 
		
		Arrays.sort(sortArr); //일단 정렬부터 함 
		
		//정렬된 배열을 순회하면서 Map에 넣어줌 
		int rank = 0; 
		for (int i : sortArr) {
			//만약 앞선 원소가 이미 순위가 매겨졌다면 중복되면 안되니까 
			//원소가 중복되지 않을 때만 Map에 원소와 그에 대응되는 순위를 넣어줌 
			if (!rankMap.containsKey(i)) {
				rankMap.put(i, rank); //map에 넣고 나면 다음 순위를 가리킬 수 있도록 1을 더해줌 
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder(); 
		for (int key : arr) {
			int ranking = rankMap.get(key); //원본 원소 배열(key)에 대한 value(순위)를 가져온다
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
	}
		
}
