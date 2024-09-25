package _20240902;

import java.util.*;
import java.io.*;

public class _21608_상어초등학교 {
	static int N;
	static int[][] seat;
	static int[][] friends;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		seat = new int[N][N];
		friends = new int[N*N+1][4];
		
		for(int i=0;i<N*N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			for(int j=0;j<4;j++) {
				friends[student][j] = Integer.parseInt(st.nextToken());
			}
			
			assignSeat(student);
		}
		
		System.out.println(calculateSatisfaction());
	}//main
	
	private static void assignSeat(int student) {
        int maxFriends = -1;
        int maxEmpty = -1;
        int finalX = -1;
        int finalY = -1;

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (seat[i][j] != 0) continue;
                int friendsCount = 0;
                int emptyCount = 0;

                for (int d=0;d<4;d++) {
                    int nx=i+dx[d];
                    int ny=j+dy[d];

                    if (nx<0 || ny<0 || nx>=N || ny>=N) continue;
                    
                    // 해당 칸 근처에 빈자리 카운트
                    if (seat[nx][ny] == 0) {
                        emptyCount++;
                    } else {
                    // 해당 칸 근처에 좋아하는 학생 몇명 있는지 카운트
                        for (int k=0;k<4;k++) {
                            if (seat[nx][ny] == friends[student][k]) {
                                friendsCount++;
                                break;
                            }
                        }
                    }
                }
                // 지금 칸에서 근처 친구 수가 가장 최대이거나
                // 근처 친구 수가 최대와 같고 빈 칸 수가 최대보다 클 경우에
                // 최댓값들과 최종 좌석자리를 갱신해준다
                
                // 어차피 행, 열이 작은 지점부터 시작하기 때문에 현재와 같은 조건일 경우엔 갱신하지 않는다
                // (어차피 더 작은 경우가 우선순위이므로 굳이 갱신할 필요 없음)
                if (friendsCount > maxFriends || (friendsCount == maxFriends && emptyCount > maxEmpty)) {
                    maxFriends = friendsCount;
                    maxEmpty = emptyCount;
                    finalX = i;
                    finalY = j;
                }
            }
        }
        // 최종 결정된 좌석 위치에 학생 번호를 적는다
        seat[finalX][finalY] = student;
    }

    private static int calculateSatisfaction() {
        int totalSatisfaction = 0;

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                int student = seat[i][j];
                int friendsCount = 0;

                for (int d=0;d<4;d++) {
                    int nx = i+dx[d];
                    int ny = j+dy[d];

                    if (nx<0 || ny<0 || nx>=N || ny>=N) continue;
                    // 4방향에 좋아하는 학생이 있는 경우 카운트를 추가해준다
                    for (int k=0;k<4;k++) {
                        if (seat[nx][ny] == friends[student][k]) {
                            friendsCount++;
                            break;
                        }
                    }
                }
                // 해당 학생의 만족도를 총 만족도에 추가해준다
                if (friendsCount > 0) {
                    totalSatisfaction += Math.pow(10, friendsCount-1);
                }
            }
        }

        return totalSatisfaction;
    }
}
