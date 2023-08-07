//시간초과 고려2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class abc {

	public static void main(String[] args) throws IOException {

//1. InputStreamReader를 생성한 후 이를 이용해 문자기반의 보조스트림 BufferedReader 생성
		//BufferedReader의 readLine()을 사용하면 데이터를 라인 단위로 읽을 수 있음 
		//InputStreamReader는 바이트기반 스트림을 문자기반 스트림으로 연결시켜주는 역할
		//스트림을 먼저 생성한 후에 이를 이용해서 보조스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//2. StringBuilder를 생성
		//StringBuilder는 StringBuffer에서 쓰레드의 동기화만 뺀 것.
		//StringBuffer append()는 반환타입이 StringBuffer (자기 주소 반환)
		StringBuilder sb = new StringBuilder();
		
//3. 데이터를 라인 단위로 읽어와 int로 형변환하여 N에 저장
		int N = Integer.parseInt(br.readLine());

//4. 크기가 N인 배열 생성
		int[] arr = new int[N];
		
//5. arr에 들어갈 값을 라인 단위로 읽어와 저장(N번)
		for (int i = 0; i < N; i++) {
			
			//Integer.parseInt(Integer클래스의 static함수 parseInt)
			//문자열을 숫자로 변환
			arr[i] = Integer.parseInt(br.readLine());

		}
		
//6. 오름차순 정렬
		//Arrays.sort( ) 배열을 정렬할 때.
		Arrays.sort(arr);
		
//7. append()로 내용추가 +출바꿈
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append('\n');
		}
		
		System.out.println(sb);

	}

}
