package _20240711;

import java.util.*;
import java.io.*;

public class _17140_이차원배열과연산 {
	
	static int r, c, k;
	static int[][] array;
	static int time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		array = new int[3][3];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solve());
		
	}
	
	static int solve() {
		time=0;
		while(time<=100) {
			
			// 조건 만족시 time을 출력하고 아닐 경우
			// R연산 혹은 C연산을 수행한 후, time을 추가한다
			if(r <array.length && c<array[0].length && array[r][c]==k) {
				return time;
			}
			
			// 행의개수 >= 열의개수 인 경우 R연산을 수행하고
			// 행의개수 < 열의개수 인 경우 C연산을 수행한다
			if(array.length >= array[0].length) {
				ROperation();
			}else {
				COperation();
			}
			time++;
		}
		// 조건을 만족하지 못한다면(k에 도달하지 못한다면) -1을 출력한다
		return -1;
		
	} // solve
	
	// R연산
	static void ROperation() {
		
		// 각 행의 최대길이 저장
		int maxCol=0;
		
		// 정렬된 행을 리스트 형태로 저장
		List<int[]> rowList = new ArrayList<>();
		
		for(int[] row : array) {
			
			// array 배열에서 행을 하나씩 꺼내서 아래 로직을 수행한다
			// countMap을 만들어서 그 행에 있는 숫자와 그 숫자의 빈도를 계산하여 저장한다
			Map<Integer, Integer> countMap = new HashMap<>();
			for(int num : row) {
				if(num ==0) continue;
				countMap.put(num, countMap.getOrDefault(num, 0)+1);
			}
			
			// HashMap형식으로 저장한 것을 쌍으로 리스트로 옮겨서 다시 저장해준다
			List<int[]> countList = new ArrayList<>();
			for(int key : countMap.keySet()) {
				countList.add(new int[] {key,countMap.get(key)});
			}
			
			// 빈도 오름차순으로 정렬하고, 빈도가 같을 경우 숫자 오름차순으로 정렬한다 
			Collections.sort(countList, (a,b) ->{
				if(a[1] == b[1]) return a[0] - b[0];
				return a[1] - b[1];
			});
			
			// 새로운 행으로 들어갈 숫자들을 새롭게 만든 리스트에 순서대로 저장한다
			// 앞서 쌍으로 저장했던 것들을 쌍이 아닌 개별의 숫자로 저장하는 과정이다
			List<Integer> newRow = new ArrayList<>();
			for(int[] p : countList) {
				newRow.add(p[0]);
				newRow.add(p[1]);
			}
			
			// 이렇게 만들어진 새로운 행의 크기 중에서 최대 크기를 저장한다
			// 최대 크기를 기준으로 array의 크기를 다시 만들기 위함이다
			maxCol = Math.max(maxCol, newRow.size());
			
			// 앞서 만든 rowList에서 새롭게 만든 행에 해당하는 부분을 갱신해준다
			// 이때 newRow를 배열로 변환하여 rowList에 추가한다
			rowList.add(newRow.stream().mapToInt(Integer::intValue).toArray());
			
		}
		
		// 새로운 크기로 array 크기를 다시 설정하고,
		// 그 안을 새롭게 바뀐 행들로 채워준다
		array = new int[array.length][maxCol];
		for(int i=0;i<rowList.size();i++) {
			System.arraycopy(rowList.get(i), 0, array[i], 0, rowList.get(i).length);
		}
		
	} // ROperation
	
	//C연산
	static void COperation() {
		// 각 열의 최대길이 저장
        int maxRow = 0;
        
        // 정렬된 열을 리스트 형태로 저장
        List<int[]> colList = new ArrayList<>();
        
        for (int j = 0; j < array[0].length; j++) {
        	
        	// array 배열에서 열을 하나씩 꺼내서 아래 로직을 수행한다
        	// countMap을 만들어서 그 열에 있는 숫자와 그 숫자의 빈도를 계산하여 저장한다
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int[] ints : array) {
                int num = ints[j];
                if (num == 0) continue;
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            
            // HashMap형식으로 저장한 것을 쌍으로 리스트로 옮겨서 다시 저장해준다
            List<int[]> countList = new ArrayList<>();
            for (int key : countMap.keySet()) {
                countList.add(new int[]{key, countMap.get(key)});
            }
            
            // 빈도 오름차순으로 정렬하고, 빈도가 같을 경우 숫자 오름차순으로 정렬한다 
            Collections.sort(countList, (a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });
            
            // 새로운 열으로 들어갈 숫자들을 새롭게 만든 리스트에 순서대로 저장한다
         	// 앞서 쌍으로 저장했던 것들을 쌍이 아닌 개별의 숫자로 저장하는 과정이다
            List<Integer> newCol = new ArrayList<>();
            for (int[] p : countList) {
                newCol.add(p[0]);
                newCol.add(p[1]);
            }
            
            // 이렇게 만들어진 새로운 열의 크기 중에서 최대 크기를 저장한다
         	// 최대 크기를 기준으로 array의 크기를 다시 만들기 위함이다
            maxRow = Math.max(maxRow, newCol.size());
            
            // 앞서 만든 colList에서 새롭게 만든 열에 해당하는 부분을 갱신해준다
         	// 이때 newCol를 배열로 변환하여 colList에 추가한다
            colList.add(newCol.stream().mapToInt(Integer::intValue).toArray());
            
        }
        
        // 새로운 크기로 array 크기를 다시 설정하고,
     	// 그 안을 새롭게 바뀐 열들로 채워준다
        array = new int[maxRow][array[0].length];
        for (int j = 0; j < colList.size(); j++) {
            for (int i = 0; i < colList.get(j).length; i++) {
                array[i][j] = colList.get(j)[i];
            }
        }
        
    } // COperation

}
