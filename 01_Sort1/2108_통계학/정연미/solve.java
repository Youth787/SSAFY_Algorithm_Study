import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {

//		산술평균 : N개의 수들의 합을 N으로 나눈 값 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
//		중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
//		최빈값 : N개의 수들 중 가장 많이 나타나는 값 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
//		범위 : N개의 수들 중 최댓값과 최솟값의 차이

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		// 산술평균
		int sum = 0;
		for (int a : array)
			sum += a;
		double avg = sum / N;
		System.out.println(Math.round(avg * 100) / 100.0); // 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

		// 중앙값 출력
		Arrays.sort(array);
		System.out.println(array[N / 2]);

		// 최빈값 출력
		// https://vanillacreamdonut.tistory.com/91
		Map<Integer, Integer> mp = new HashMap<>();

		if (N == 1) {
			System.out.println(array[0]);
		}
		for (int i = 0; i < N; i++) {
			if (mp.containsKey(array[i])) {
				mp.put(array[i], mp.get(array[i]) + 1); // mp.put(key,value) :  값 추가 
			} else {
				mp.put(array[i], 1);
			}
		}
		// 동일한 키를 포함하고 있으면 +1씩 개수를 늘린다.
		// 없다면 본인만 존재 : 1개로 설정. 

		int maxValue = Collections.max(mp.values());
		// mp의 value중에서 가장 큰 값을 maxvalue에 넣는다. 
		ArrayList<Integer> arrayList = new ArrayList<>();
		// 새로운 리스트 생성.

		for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
			// map에 값을 전체 출력하기 위해서는 entryset(), keyset() 메소드를 사용.
			// entryset() 메소드는 key와 value의 값이 모두 필요한 경우 사용한다. 
			// keyset() 메소드는 key의 값만 필요한 경우 사용한다. 
			if (m.getValue() == maxValue) {
				arrayList.add(m.getKey());
			}
			// 가장 빈도수가 높은 값에 해당하는 key값을 리스트에 넣는다. 
		}
		
		Collections.sort(arrayList);
		// 가장 많이 나온 값이 여러개일 경우 두번째로 작은 값
		if (arrayList.size() > 1)
			System.out.println(arrayList.get(1));
		else // 가장 많이 나온 값이 하나면
			System.out.println(arrayList.get(0));
		

		// 범위 출력
		System.out.println(array[N-1]-array[0]);
	}
}
