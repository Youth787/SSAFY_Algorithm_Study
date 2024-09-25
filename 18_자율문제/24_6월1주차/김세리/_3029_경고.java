package _20240602;

import java.util.Scanner;

public class _3029_경고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String now = sc.next();
		String time = sc.next();
		int nowh = Integer.parseInt(now.substring(0,2));
		int nowm = Integer.parseInt(now.substring(3,5));
		int nows = Integer.parseInt(now.substring(6,8));
		
		int timeh = Integer.parseInt(time.substring(0,2));
		int timem = Integer.parseInt(time.substring(3,5));
		int times = Integer.parseInt(time.substring(6,8));
		
		int waith, waitm, waits =0;
		
		if(times>=nows) waits = times-nows;
		else {
			waits = 60+times - nows;
			timem--;
		}
		
		if(timem>=nowm) waitm = timem-nowm;
		else {
			waitm = 60 + timem - nowm;
			timeh--;
		}
		
		if(timeh>=nowh) waith = timeh-nowh;
		else {
			waith = 24+timeh - nowh;
		}
		
		if(waith==0 && waitm==0 && waits==0) waith=24;
		
		if(waith<10) System.out.print("0"+waith+":");
		else System.out.print(waith+":");
		if(waitm<10) System.out.print("0"+waitm+":");
		else System.out.print(waitm+":");
		if(waits<10) System.out.print("0"+waits);
		else System.out.print(waits);
		
	}//main

}
