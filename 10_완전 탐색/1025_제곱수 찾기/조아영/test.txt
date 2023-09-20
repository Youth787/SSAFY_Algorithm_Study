import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main1025_제곱수 {
	
	static int n, m;
	static int[][] arr;
	static int[] number; //나중에 이어붙여서 int나 double로 바꿀래 
	static int[] number2; 
	static int max; 
//	static List<Double> list = new ArrayList<>(); 
	static HashSet<String> set = new HashSet<>(); 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		n = tmp.charAt(0)-'0';
		m = tmp.charAt(2)-'0';
		arr = new int[n][m];
		max = -1; 
		
		for (int i=0; i<n; i++) {
			tmp = br.readLine();
			for (int j=0; j<m; j++) {
				arr[i][j] = tmp.charAt(j)-'0';
			}
			//System.out.println(Arrays.toString(arr[i]));
		}
		
		//일단 정수를 만들어야 하는데 
		//1개 이상의 칸 선택 (끝까지 안가도됨 중간마다 체크해줘야) 근데 가장 큰 수 찾으려면 끝까지 간 경우부터 봐야하나? 
		//선택한 칸의 행 번호, 열 번호 등차수열 이뤄야 
		//초항 결정했으니 공차 정해야해 공차는 0~n-1, 0~m-1 까지 가능 
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) { //시작지점 결정 (i,j) 
				bfs(i,j);
			}
		}
		
		System.out.println(max);
		
	}
	
	static void bfs(int i, int j) { //(i,j는 시작지점) 
		
		for (int k=0; k<n; k++) {
			for (int l=0; l<m; l++ ) { //공차 결정 (k,l)
				
				if (k==0 && l==0) continue; 
				
				int length = Math.max(n, m);

				
				//시간초과 
//				int[][] number = new int[4][length];
//				for (int a=0; a<4; a++) {
//					Arrays.fill(number[a], -1);
//				}

//				int cnt=0;
//				for (int dr=0, dc=0; cnt<length; dr+=k, dc+=l, cnt++) {
//					if (i+dr>=0 && i+dr<n && j+dc>=0 && j+dc<m) number[0][cnt] = arr[i+dr][j+dc];
//					if (i+dr>=0 && i+dr<n && j-dc>=0 && j-dc<m) number[1][cnt] = arr[i+dr][j-dc]; 
//					if (i-dr>=0 && i-dr<n && j+dc>=0 && j+dc<m) number[2][cnt] = arr[i-dr][j+dc];
//					if (i-dr>=0 && i-dr<n && j-dc>=0 && j-dc<m) number[3][cnt] = arr[i-dr][j-dc];
//				}
				
				//숫자 다 골랐으면 이어붙여서 제곱수인지 판별하고, 제곱수면 최댓값인지 확인  
//				for (int a=0; a<4; a++) {
//					StringBuilder sb = new StringBuilder();
//					for (int b=0; b<cnt; b++) {
//						if (number[a][b]!=-1) sb.append(number[a][b]);
//						double num = Double.parseDouble(sb.toString()); //숫자 만들어서  	
//						if (num>max && !list.contains(num)) {
//							double sqrt = Math.sqrt(num); //루트씌워서 어쩌고저쩌고 
//							if (sqrt%(int)sqrt==0) max = (int)num;
//						}
//						list.add(num);
//					}
//				}
				
				
				//메모리초과 
				StringBuilder sb1 = new StringBuilder(); 
				StringBuilder sb2 = new StringBuilder(); 
				StringBuilder sb3 = new StringBuilder(); 
				StringBuilder sb4 = new StringBuilder(); 	
				
				int cnt=0;
				for (int dr=0, dc=0; cnt<length; dr+=k, dc+=l, cnt++) {
					if (i+dr>=0 && i+dr<n && j+dc>=0 && j+dc<m) {
						sb1.append(arr[i+dr][j+dc]);
						set.add(sb1.toString());
					}
					if (i+dr>=0 && i+dr<n && j-dc>=0 && j-dc<m) {
						sb2.append(arr[i+dr][j-dc]);
						set.add(sb2.toString());
					}
					if (i-dr>=0 && i-dr<n && j+dc>=0 && j+dc<m) {
						sb3.append(arr[i-dr][j+dc]);
						set.add(sb3.toString());
					}
					if (i-dr>=0 && i-dr<n && j-dc>=0 && j-dc<m) {
						sb4.append(arr[i-dr][j-dc]);
						set.add(sb4.toString());
					}
				}
				
				
				String[] tmp = set.toArray(new String[0]);
				for (int a=0; a<set.size(); a++) {
					double num = Double.parseDouble(tmp[a]); //숫자 만들어서  	
					if (num>max) {
						double sqrt = Math.sqrt(num); //루트씌워서 어쩌고저쩌고 
						if (sqrt%(int)sqrt==0) max = (int)num;
					}
				}
				
				//메모리초과
//				Iterator<String> it = set.iterator(); 
//				for (int a=0; a<set.size(); a++) {
//					double num = Double.parseDouble(it.next()); //숫자 만들어서  	
//					if (num>max) {
//						double sqrt = Math.sqrt(num); //루트씌워서 어쩌고저쩌고 
//						if (sqrt%(int)sqrt==0) max = (int)num;
//					}
//				}
				
				
				
			}
		}
		
	}
	

}
