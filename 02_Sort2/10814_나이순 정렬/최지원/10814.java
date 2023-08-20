
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * [문제] 가입순으로 사람들의 나이, 이름  주어짐. 나이 오름차순(나이 같으면 가입 먼저 한 순으로) 정렬
 * [조건] 1<=N<=100000. 1<=나이<=200, 이름은 알파벳 대소문자, 길이가 100보다 작거나 같은 문자열
 * [입력] 첫 줄 사람 수 N, 다음부터 사람의 나이와 이름
 * 
 * */

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 사용
		int N = Integer.parseInt(br.readLine()); //사람 수 N
		
		String [][] ageName = new String [N][2]; //아예 나이도 문자열처럼 저장한 후 비교할 때 Integer.parseInt로 형변환하자
		
		StringTokenizer st; //StringTokenizer 사용
		
		for (int i=0; i < N; i ++) {
			st = new StringTokenizer(br.readLine()," ") ; //입력이 나이 (한 칸 띄고) 이름
			ageName[i][0] = st.nextToken(); //나이는 [i][0]번 인덱스에
			ageName[i][1] = st.nextToken(); //이름은 [i][1]번 인덱스에 저장
		}

		

		Arrays.sort(ageName, new Comparator<String[]>() { //ageName 이라는 배열에 대해 String[]라는 형을 비교할꺼임
			public int compare(String[] str1, String[] str2) { //String[]형인 str1과 str2를 비교하는데
				return Integer.parseInt(str1[0]) - Integer.parseInt(str2[0]); 
       			 //형변환한 나이를 비교하겠다. 같으면 어짜피 가입(입력받은) 순 그래도 유지될 것
			}
		});
		
		StringBuilder sb = new StringBuilder(); //StringBuilder 사용
		
		for (int i = 0 ; i < N ; i++) {
			sb.append(ageName[i][0]).append(' ').append(ageName[i][1]).append('\n');
		} //정렬된 좌표를 append 사용하여 쭉 이어진 문자열로 만들고
		
		System.out.println(sb); //출력
		
		
	}

}


//추가내용들
/* Comparator로 2차원배열 정렬 구현하는 방법
import java.util.Arrays;
import java.util.Comparator;

int[][] arrays = { { 0, 3 }, { 2, 6 }, { 1, 9 }, { 1, 8 } };

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
