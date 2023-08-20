
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * [문제] 수직선 위 N개의 좌표에 압축을 적용한 결과 출력. 압축 결과는 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같음
 * [입력] 첫 줄에 좌표 개수 N, 다음 줄에 공백으로 구분된 좌표들 (출력도 한 칸으로 구분)
 * [조건] 1<=N<=1000000. -10^9 <= 좌표 <= 10^9 
 * */

/* 압축 결과 = Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수 
 * [예제 입력] 2 4 -10 4 -9
 * [압축 결과] 2(2보다 작은 수 2개) 3(4보다 작은 수 3개) 0(-10보다 작은수 0개) ...
 * */

public class Main {
	 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 사용
		
		int N = Integer.parseInt(br.readLine()); //좌표 개수 N
		
		int[] arr = new int[N];	// 입력 받는 배열
		int[] stArr = new int[N];	// 정렬용 배열
		
		//HashMap<int형, int형>  HashMap이름 = new  HashMap <>()
		HashMap<Integer, Integer> rank = new HashMap<>();
 
		//StringTokenizer 사용 : BufferedReader로 읽은 한 줄을 공백 기준으로 나눈다
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			stArr[i] = arr[i]; 
		} //arr와 stArr에 모두 값 입력
		
		Arrays.sort(stArr); //원본은 냅두고 stArr는 정렬한다
		
		// 정렬 된 배열을 순회하며 map에 넣는 과정
		int ranking = 0;
		for(int v : stArr) { 
			if(!(rank.containsKey(v))) {
				rank.put(v, ranking); //중복 되지 않은 경우에만 map에 원소와 순위를 넣음(put)
				ranking++;		// 다음 순위에 사용 (+1)
			}
		}
		
		StringBuilder sb = new StringBuilder(); //StringBuilder 사용
		for(int key : arr) {
			int rankk = rank.get(key);	// 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
			sb.append(rankk).append(' ');
		}
		
		System.out.println(sb); //출력
		
		
 
	}
}
