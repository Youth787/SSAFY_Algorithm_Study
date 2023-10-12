//풀이 1 : ( https://velog.io/@dailyhyun/BOJ%EB%B0%B1%EC%A4%80-2239.-%EC%8A%A4%EB%8F%84%EC%BF%A0-Java )
//main, dfs,isValid 로 구성

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[][] map;//스도쿠 숫자 채울 2차원배열 
	static boolean end;//스도쿠 채우기가 끝났는지 표현하는 boolean 변수(필요한가..?)
	
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
			//입력
			
			dfs(0);
			//빈 부분 작성
			
			for (int i = 0; i < 9; ++i) {
				for (int j = 0; j < 9; ++j) {
					bw.write(map[i][j]+"");
				}bw.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//작성한 스도쿠 출력
	

	//0으로 된 칸 채우는 dfs. 인자는 지금 탐색하는 칸의 번호(depth)
	public static void dfs(int depth) {
	//기저 : 모든 칸을 다 돌았을 때(depth가 0~8까지 돌고 81이 되었을때
		if (depth == 81) {
			end = true;//스도쿠 채우기가 끝났다
			return;//리턴
		}
		
		//내부에서 사용할 변수를 인자를 통해 만든다
		int y = depth / 9;//depth를 9로 나눴을때 몫은 현재 칸이 몇번째 행에 있는지 (0~8)
		int x = depth % 9;//나머지는 현재칸이 몇번째 열에 있는지 (0~8)
		
		if (map[y][x] != 0) {
			//칸이 이미 채워져있으면 다음칸으로 넘어가
			dfs(depth + 1);
		} else {
			//값이 0이면 아직 미작성한 칸이므로 for문을 통해 1~9 숫자를 넣어보겠다
			for (int i = 1; i <= 9; ++i) {
				//map[y][x]에 i가 가능한지 isValid에서 확인하여
				if (!isVaild(y, x, i)) continue;//불가능하면 숫자 i는 넘어가, 다음 숫자 넣어본다
				//숫자 i를 넣는게 가능하다면
				map[y][x] = i;//넣고
				dfs(depth + 1);//다음칸으로 넘어간다
				if (end) return;//기저조건에 있는 end가 true상태로 리턴되었다면, 여기 if문에서도 리턴=어디로 나가지???
				map[y][x] = 0;//못채웠네 하고 다시 그 칸 값을 0으로 만듬
			}
		}
	}
	
	//map[y][x]에 n을 넣을 수 있는지 확인
	public static boolean isVaild(int y, int x, int n) {
		//가로, 세로 줄 에 같은 숫자가 있는지 확인
		for (int i = 0; i < 9; ++i) {
			if (map[y][i] == n || map[i][x] == n) return false;
		}
		
		//3 * 3 칸안에 같은 숫자가 있는지 확인 
		int yy = y / 3 * 3;
		int xx = x / 3 * 3;
		for (int i = yy; i < yy + 3; ++i) {
			for (int j = xx; j < xx + 3; ++j) {
				if (map[i][j] == n) return false;
			}
		}
		return true;//아닌 경우에는 그 자리에서 false로 리턴했고, 남은 경우는 n 넣기 가능하기 때문에 true로 리턴
	}
}

//-----------------------------------------------------------------------------------------------
//풀이 2:  (https://velog.io/@dailyhyun/BOJ%EB%B0%B1%EC%A4%80-2239.-%EC%8A%A4%EB%8F%84%EC%BF%A0-Java ) 





//-----------------------------------------------------------------------------------------------
//풀이 3 : bit 연산을 사용 ( https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-2239-%EC%9E%90%EB%B0%94-%EC%8A%A4%EB%8F%84%EC%BF%A0-BOJ-2239-JAVA )
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
