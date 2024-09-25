package _20240602;

import java.util.Scanner;

public class _11365_밀비급일 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String st = "";
		while(!st.equals("END")) {
			st = sc.nextLine();
			if(st.equals("END")) break;
			int n = st.length();
			for(int i=n-1;i>=0;i--) {
				System.out.print(st.substring(i,i+1));
			}
			System.out.println();
		}
	}//main

}
