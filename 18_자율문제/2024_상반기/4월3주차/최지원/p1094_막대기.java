

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());

		int stick = 64;
		int temp = 0;
		int count = 0;
		int result = X;

		while (true) {

			if (X == 64) {
				count++;
				break;
			}

			stick /= 2; //
			if (stick <= X) {
				temp += stick; 
				count++;
				if (result == temp) {
					break;
				}
				X -= stick;
			}

		}
		System.out.println(count);

	}

}
