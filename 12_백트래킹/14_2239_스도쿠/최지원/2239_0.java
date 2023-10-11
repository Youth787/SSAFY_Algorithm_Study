//풀이 1 : ( https://velog.io/@dailyhyun/BOJ%EB%B0%B1%EC%A4%80-2239.-%EC%8A%A4%EB%8F%84%EC%BF%A0-Java )
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[][] map;
	static boolean end;
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			map = new int[9][9];
			for (int i = 0; i < 9; ++i) {
				String input = br.readLine();
				for (int j = 0; j < 9; ++j) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			dfs(0);
			
			for (int i = 0; i < 9; ++i) {
				for (int j = 0; j < 9; ++j) {
					bw.write(map[i][j]+"");
				}bw.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dfs(int depth) {
		if (depth == 81) {
			end = true;
			return;
		}
		
		int y = depth / 9;
		int x = depth % 9;
		
		if (map[y][x] != 0) {
			dfs(depth + 1);
		} else {
			for (int i = 1; i <= 9; ++i) {
				if (!isVaild(y, x, i)) continue;
				map[y][x] = i;
				dfs(depth + 1);
				if (end) return;
				map[y][x] = 0;
			}
		}
	}
	
	public static boolean isVaild(int y, int x, int n) {
		for (int i = 0; i < 9; ++i) {
			if (map[y][i] == n || map[i][x] == n) return false;
		}
		
		int yy = y / 3 * 3;
		int xx = x / 3 * 3;
		for (int i = yy; i < yy + 3; ++i) {
			for (int j = xx; j < xx + 3; ++j) {
				if (map[i][j] == n) return false;
			}
		}
		return true;
	}
}

//-----------------------------------------------------------------------------------------------
//풀이 2:  (https://velog.io/@dailyhyun/BOJ%EB%B0%B1%EC%A4%80-2239.-%EC%8A%A4%EB%8F%84%EC%BF%A0-Java ) 





//-----------------------------------------------------------------------------------------------
//풀이 3 : bit 연산을 사용 https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-2239-%EC%9E%90%EB%B0%94-%EC%8A%A4%EB%8F%84%EC%BF%A0-BOJ-2239-JAVA
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Candidate {
    int r,c,gridNum;
    public Candidate(int r, int c, int gridNum) {
        this.r = r;
        this.c = c;
        this.gridNum = gridNum;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int[][] chk = new int[3][9];
    private int[][] answer = new int[9][9];
    private ArrayList<Candidate> candidate = new ArrayList<>();

    private void initUserInput() throws Exception {
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int cur = line.charAt(j)-'0';
                int gridNum = i/3*3+j/3;

                if (cur == 0) {
                    candidate.add(new Candidate(i,j,gridNum));
                    continue;
                }
                answer[i][j] = cur;
                chk[0][i]|=1<<cur;
                chk[1][j]|=1<<cur;
                chk[2][gridNum]|=1<<cur;
            }
        }
    }

    private void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(answer[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private boolean search(int idx) {
        if (idx == candidate.size()) {
            return true;
        }

        Candidate cur = candidate.get(idx);
        for (int num = 1; num <= 9; num++) {
            if ( (chk[0][cur.r]&1<<num)!=0 || (chk[1][cur.c]&1<<num)!=0 || (chk[2][cur.gridNum]&1<<num)!=0 )
                continue;

            chk[0][cur.r]|=1<<num;
            chk[1][cur.c]|=1<<num;
            chk[2][cur.gridNum]|=1<<num;
            answer[cur.r][cur.c] = num;

            if (search(idx+1)) return true;

            chk[0][cur.r]&=~(1<<num);
            chk[1][cur.c]&=~(1<<num);
            chk[2][cur.gridNum]&=~(1<<num);
        }
        return false;
    }

    private void solution() throws Exception {
        initUserInput();
        search(0);
        printAnswer();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
