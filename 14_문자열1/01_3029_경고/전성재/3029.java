import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			String S1 = br.readLine();
			String S2 = br.readLine();
			String[] s1 = S1.split(":");
			String[] s2 = S2.split(":");
			int[] n = new int[3];
			
			for (int j = 0; j < 3; j++) {
				n[j] = Integer.parseInt(s2[j]) - Integer.parseInt(s1[j]);
			}
	
			if (S1.equals(S2)) {
				System.out.println("24:00:00");
			} else {
				if (n[2] < 0) {
					n[2] += 60;
					n[1]--;
				}
				if (n[1] < 0) {
					n[1] += 60;
					n[0]--;
				}
				if (n[0] < 0) {
					n[0] += 24;
				}
				System.out.format("%02d:%02d:%02d", n[0], n[1], n[2]);
			}

			

		
	}

}
