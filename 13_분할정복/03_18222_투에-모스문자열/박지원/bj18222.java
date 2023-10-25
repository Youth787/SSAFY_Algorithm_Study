import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//솔직히 너무 어려움..
public class bj18222 {
	
	static long[] map; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long k = Long.parseLong(br.readLine());
		map = new long[65]; // 인덱스 값에 따라 해당 시점의 자릿수를 담고있는 map을 만든다
		map[0] = 1;
		for (int i = 1; i < 65; ++i) {
			map[i] = map[i - 1] * 2;
		}
		System.out.println(get(k));
		
	}
	//10번째 자리구할거야 > 10번째 자리에서 8자리를 역순으로 돌아가게 되면 10번재 자리의 값을 반전시킨 숫자가 존재하는 원리
	//20번째 자리구할거야 > 20번째 자리에서 16자리를 역순으로 돌아가게 되면 20번째 자리의 값을 반전시킨 숫자가 존재하는 원리
	static long get(long k) {
		if (k == 1) return 0;
		for (int i = 0; i < 65; ++i) {
			if (k <= map[i])
				return 1 - get(k - map[i - 1]);
		}
		return 0;
	}
}

//https://velog.io/@jh5253/%EB%B0%B1%EC%A4%80-18222-%ED%88%AC%EC%97%90-%EB%AA%A8%EC%8A%A4-%EB%AC%B8%EC%9E%90%EC%97%B4-Java%EC%9E%90%EB%B0%94
// x  0      01     0110     01101001
// x` 1      10     1001     10010110
// x  01     0110   01101001 0110100110010110
// k 1       2      3          4
// x길이 2     4      8          16
