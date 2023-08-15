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
		
		Arrays.sort(arr, new Comparator<String>() { //Arrays.sort 사용(arr에서 새롭게 String형을 비교하겠다)
			public int compare(String str1, String str2) { //문자열 str1과 str2를 비교하는데
				if (str1.length() == str2.length()) {
					return str1.compareTo(str2); //2번 기준 : str1와 str2의 길이가 같다면 사전 순
				} else {
					return str1.length() - str2.length(); //1번 기준 : 문자열 길이가 다르다면 길이 순으로
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();		//StringBuilder 사용
		
		
		sb.append(arr[0]).append('\n'); //0번은 우선 출력한 후
		for (int i = 1; i<N; i++) { 
			if (!(arr[i].equals(arr[i-1]))) {
				sb.append(arr[i]).append('\n');
			} //1번부터는 그 앞의 인덱스와 중복인 경우를 제외하고 append
		}
		
		System.out.println(sb); //출력
		

	}

}
