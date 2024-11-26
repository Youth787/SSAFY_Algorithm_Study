package _20241120;

import java.util.*;
import java.io.*;

public class _2469_사다리타기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		char[] start = new char[k];
		for(int i=0;i<k;i++) {
			start[i]= (char) ('A'+i);
		}
		
		char[] last = br.readLine().toCharArray();
		char[][] ladder = new char[n][k-1];
		int questionRow = -1;
		
		boolean chk=false;
		int afterQuestionmark = 0;
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			ladder[i] = line.toCharArray();
			if(line.contains("?")) {
				questionRow=i;
			}
		}
		
		for(int i=0;i<questionRow;i++) {
			for(int j=0;j<k-1;j++) {
				if(ladder[i][j]=='-') {
					char tmp = start[j];
					start[j]=start[j+1];
					start[j+1]=tmp;
				}
			}
		}
		
		for(int i=n-1;i>questionRow;i--) {
			for(int j=0;j<k-1;j++) {
				if(ladder[i][j]=='-') {
					char tmp = last[j];
					last[j]=last[j+1];
					last[j+1]=tmp;
				}
			}
		}
		
		char[] ans = new char[k-1];
		boolean impossible = false;
		
		for(int i=0;i<k-1;i++) {
			if(start[i]==last[i]) {
				ans[i]='*';
			}
			else if(start[i+1]==last[i] && start[i]==last[i+1]) {
					ans[i]='-';
					char tmp = start[i];
					start[i] = start[i+1];
					start[i+1] = tmp;
			} else {
				impossible=true;
				break;
			}
		}
		if(impossible) {
			for(int i=0;i<k-1;i++) {
				System.out.print("x");
			}
		}else {
			for(char an : ans) {
				System.out.print(an);
			}
		}
	}

}
