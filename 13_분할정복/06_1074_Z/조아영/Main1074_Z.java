import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()); //행
		int c = Integer.parseInt(st.nextToken()); //열
		int size = (int) Math.pow(2, N); //한 변의 사이즈
		
		find(size, r, c);
		System.out.println(count);
	}

	//배열을 사분면으로 나누고, 입력받은 r, c가 몇 번째 사분면에 속하는지만 알면 된다.
	private static void find(int size, int r, int c) {
		if(size == 1) //size가 1이 되면 재귀를 끝낸다.
			return;

		//r과 c가 1사분면에 속한다면, 앞에서 아무데도 방문하지 않았으므로 count를 그냥 두고
		// find메소드에 현재 size의 절반, 1사분면에서의 r,c 상대위치 r,c를 넘겨준다.
		if(r < size/2 && c < size/2) {
			find(size/2, r, c);
		}

		// r과 c가 2사분면에 속한다면, 앞에서 1사분면을 방문해야하므로 count에 (size*size)/4를 더한다.
		//find메소드에 현재 size의 절반, 2사분면에서의 r,c 상대위치 r, c-size/2를 넘겨준다.
		else if(r < size/2 && c >= size/2) {
			count += size * size / 4;
			find(size/2, r, c - size/2);
		}

		//r과 c가 3사분면에 속한다면, 앞에서 1,2 사분면을 방문해야하므로 count에 (size*size)/4 * 2를 더한다.
		//find메소드에 현재 size의 절반, 3사분면에서의 r,c 상대위치 r-size/2, c를 넘겨준다.
		else if(r >= size/2 && c < size/2) {
			count += (size * size / 4) * 2;
			find(size/2, r - size/2, c);
		}
		//r과 c가 4사분면에 속한다면, 앞에서 1,2,3 사분면을 방문해야하므로 count에 (size*size)/4 * 3를 더한다.
		//find메소드에 현재 size의 절반, 4사분면에서의 r,c 상대위치 r-size/2, c-size/2를 넘겨준다.
		else {
			count += (size * size / 4) * 3;
			find(size/2, r - size/2, c - size/2);
		}
	}
}
