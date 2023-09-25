import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
 * [문제] 알파벳 소문자로 이루어진 N개의 단어를 길이가 짧은 것부터, 길이가 같으면 사전 순으로 정렬.(중복 단어는 하나만 남기고 제거)
 * [조건] 1<=N<=20000, 문자열 길이<=50
 * [입력] 첫 줄에 단어 개수 N, 다음부터 N개의 줄에 알파벳 소문자 단어 하나씩
 * */

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 사용
		int N = Integer.parseInt(br.readLine()); //BufferedReader로 읽어와 String - int 형변환 (단어 개수 N)
		
		String [] arr = new String [N]; //N개의 단어 들어갈 arr
		
		for (int i=0; i < N; i ++) {
			arr[i] = br.readLine();
		} //일단 arr 안에 단어 넣기까지 끝

		//Comparator 
		Arrays.sort(arr, new Comparator<String>() { //Arrays.sort 사용(arr에서 새롭게 String형을 비교하겠다)
			public int compare(String str1, String str2) { //문자열 str1과 str2를 비교하는데
				if (str1.length() == str2.length()) {
					return str1.compareTo(str2); //2번 기준 : str1와 str2의 길이가 같다면 사전 순
				} else {
					return str1.length() - str2.length(); //1번 기준 : 문자열 길이가 다르다면 길이 순으로
					//기본으로 sort가 오름차순 정렬인데, str1길이 빼기 str2 길이
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();		//StringBuilder 사용
		
		
		sb.append(arr[0]).append('\n'); //0번은 우선 출력한 후
		for (int i = 1; i<N; i++) { 
			if (!(arr[i].equals(arr[i-1]))) {
				sb.append(arr[i]).append('\n');
			} //1번부터는 그 앞의 인덱스와 중복인 경우를 제외하고
			//정렬된 좌표를 append 사용하여 쭉 이어진 문자열로 만듬
		}
		
		System.out.println(sb); //출력
		

	}//Main

}//class

//추가내용들
/* Comparator로 2차원배열 정렬 구현하는 방법
import java.util.Arrays;
import java.util.Comparator;

int[][] arrays = { { 0, 3 }, { 2, 6 }, { 1, 9 }, { 1, 8 } };

틀:
Arrays.sort (정렬할 배열 이름, new Comparator <클래스 타입> 클래스명
Arrays.sort(arrays, new Comparator<int[]>() {
  @Override
  public int compare(int[] o1, int[] o2) {
    if (o1[0] == o2[0])
      return o1[1] - o2[1];
    else
      return o1[0] - o2[0];
  }
});
*/

/* 람다식으로 2차원배열 정렬 구현하는 방법
import java.util.Arrays;

int[][] arrays = { { 0, 3 }, { 2, 6 }, { 1, 9 }, { 1, 8 } };
Arrays.sort(arrays, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

*/
