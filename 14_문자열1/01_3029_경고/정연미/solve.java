package 문자열1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 경고_3029 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = 0, B = 0, result = 0;
		String[] currentTime = br.readLine().split(":");
		String[] targetTime = br.readLine().split(":");
		
		// 초단위로 전부 변환 
		A = Integer.parseInt(currentTime[2]) + Integer.parseInt(currentTime[1]) * 60 + Integer.parseInt(currentTime[0]) * 60 * 60;
        B = Integer.parseInt(targetTime[2]) + Integer.parseInt(targetTime[1]) * 60 + Integer.parseInt(targetTime[0]) * 60 * 60;
        
		if (A > B)
			result = (24 * 60 * 60 - A) + B;
		else
			result = B - A;
		
		int hour = result / (60 * 60);
		int min = (result % (60 * 60)) / 60;
		int sec = (result % (60 * 60)) % 60;
		
		if(hour==0 && min ==0 && sec==0) hour =24; 
		
		System.out.format("%02d:%02d:%02d",hour, min, sec);
	}
}
