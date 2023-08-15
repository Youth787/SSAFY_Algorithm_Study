import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * [문제] 2차원 평면 위의 점 N개를 x좌표 오름차순, x좌표가 같으면 y좌표 오름차순으로 정렬하고 출력
 * [입력] 첫 줄에 점 개수 N, 이후부터 N개의 줄에 점의 x, y 좌표
 * [조건] 좌표는 -100000~100000 항상 정수, 위치가 같은 두 점은 없음. 
 * */
public class Main {

	public static void main(String[] args) throws IOException{
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 사용
		
    int N = Integer.parseInt(br.readLine()); //N개의 점 문자열로 읽고 int 형변환
    
//		음수를 어떻게 집어넣는지에 대한 고민... 2차원 ArrayList 사용하는 방법을 잠깐은 고민했는데 못함
//    ArrayList <Integer>[] arr = new ArrayList [200000];
//		for (int i= 0; i<N; i++) {
//			arr[i] = new ArrayList<Integer>();
//		}
		
		int[][] arr = new int[N][2]; //안에 들어갈 값은 x, y 좌표(2쌍씩)가 N개라서. 안에 들어가는 값은 음수여도 상관없으니까
		
		StringTokenizer st; //문자열 분리에 사용
		
		for (int i= 0; i < N ; i++) {
      //StringTokenizer() : 지정된 문자열에 대한 문자열 토크나이저를 구성한다
			st = new StringTokenizer(br.readLine()); //BufferedReader로 읽어온 다음 줄을 StringTokenizer로 사용하겠다			

      //st.nextToken(문자열) : 이 문자열 토크나이저에서 다음 토큰을 반환한다
			arr[i][0] = Integer.parseInt(st.nextToken()); //x좌표를 arr[i][0]자리에 int 형변환을 해서 넣겠다
			arr[i][1] = Integer.parseInt(st.nextToken()); //y좌표도 마찬가지로 arr[i][1]자리에 
		} //이걸 N번 반복해서 arr 안에 값을 모두 넣는다

    //람다식 사용
		Arrays.sort(arr, (e1, e2)->{
			if (e1[0]==e2[0]) { //x좌표 같을 때는
				return e1[1]-e2[1]; //y좌표로 비교하겠다
			} else { //그게 아니면(x좌표 다르면)
				return e1[0]-e2[0]; //x좌표로 비교하겠다
			}
		});
		
		//StringBuilder 사용
		StringBuilder sb= new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]).append('\n');
		} //정렬된 좌표를 append 사용하여 쭉 이어진 문자열로 만들고
		System.out.println(sb); //출력

	}

}
