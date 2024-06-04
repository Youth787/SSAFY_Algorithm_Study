import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String time1[] = br.readLine().split(":");
		String time2[] = br.readLine().split(":");

		int hour = Integer.parseInt(time2[0]) - Integer.parseInt(time1[0]);
		int min = Integer.parseInt(time2[1]) - Integer.parseInt(time1[1]);
		int sec = Integer.parseInt(time2[2]) - Integer.parseInt(time1[2]);

		while(sec < 0) {
			sec += 60;
			min--;
		}
		while(min < 0) {
			min += 60;
			hour--;
		}
		while(hour < 0) {
			hour += 24;
		}

		if(hour==0&&min==0&&sec==0)
			hour = 24;

		System.out.printf("%02d:%02d:%02d\n", hour, min, sec);
	}
}
