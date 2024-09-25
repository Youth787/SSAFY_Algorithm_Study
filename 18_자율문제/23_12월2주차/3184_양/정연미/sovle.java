import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dir = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visit;
	static String[][] map;
	static int R,C;
	static int rSheep, rFox;
	static int sheep, fox;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		map = new String[R][C];
		for(int i=0; i<R; i++) {
			input = br.readLine().split("");
			for(int j=0; j<C;j++) map[i][j] = input[j];
		}// 입력받기 완료 

		visit = new boolean[R][C];
		for(int i =0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sheep =0;
				fox =0;
				DFS(i,j);
				if(sheep>fox) fox = 0; 
				else sheep =0;
				rSheep += sheep;
				rFox += fox;
			}
		}
		
		System.out.println(rSheep+" "+rFox);
 	}// main end 
	
	public static void DFS(int i, int j) {
		if(map[i][j].equals("#")||visit[i][j]) return;
		if(map[i][j].equals("o")) sheep ++;
		if(map[i][j].equals("v")) fox ++;
		visit[i][j]= true;
		
		for(int k=0; k<4; k++) {
			int r = i+dir[k][0];
			int c = j+dir[k][1];
			if(r>=0 && r<R && c>=0 && c<C && !visit[r][c]&& !map[r][c].equals("#")) {
				DFS(r,c);
			}
		}
	}
}
