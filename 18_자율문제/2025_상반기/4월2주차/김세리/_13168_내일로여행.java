package _20250422;

import java.util.*;
import java.io.*;

public class _13168_내일로여행 {
	static final double INF=Integer.MAX_VALUE/2; // 적당히 큰 값
	static int N, R, M, K;
	static Map<String, Integer> cityIndex = new HashMap<>();
	static double[][] noTicketCost, ticketCost;
	static int[] travelRoute;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		// map에 도시별로 인덱스 저장
		for(int i=0;i<N;i++) {
			String city = st.nextToken();
			if(!cityIndex.containsKey(city)) {
				cityIndex.put(city,idx++);
			}
		}
		N = idx;
		
		M = Integer.parseInt(br.readLine());
		travelRoute = new int[M];
		st = new StringTokenizer(br.readLine());
		// 여행 경로를 도시별 인덱스로 저장
		for(int i=0;i<M;i++) {
			travelRoute[i] = cityIndex.get(st.nextToken());
		}
		
		K = Integer.parseInt(br.readLine());
		
		// 내일로 이용할 가격 저장
		noTicketCost = new double[N][N];
		// 내일로 이용 안할 경우 가격 저장
		ticketCost = new double[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(noTicketCost[i],INF);
			Arrays.fill(ticketCost[i],INF);
			noTicketCost[i][i] = 0;
			ticketCost[i][i] = 0;
		}
		// 가격 정보 저장
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			String transport = st.nextToken();
			int from = cityIndex.get(st.nextToken());
			int to = cityIndex.get(st.nextToken());
			double cost = Double.parseDouble(st.nextToken());
			
			noTicketCost[from][to] = Math.min(noTicketCost[from][to],cost);
			noTicketCost[to][from] = Math.min(noTicketCost[to][from],cost);
			
			double discountedCost = cost;
			if(transport.equals("Mugunghwa") || transport.equals("ITX-Saemaeul") || transport.equals("ITX-Cheongchun")) {
				discountedCost = 0;
			} else if(transport.equals("S-Train") || transport.equals("V-Train")) {
				discountedCost = cost/2;
			}
			
			ticketCost[from][to] = Math.min(ticketCost[from][to], discountedCost);
			ticketCost[to][from] = Math.min(ticketCost[to][from], discountedCost);
		}
		
		floydWarshall(noTicketCost);
		floydWarshall(ticketCost);
		
		double totalNoTicket = 0;
		double totalTicket = R;
		for(int i=0;i<M-1;i++) {
			int from = travelRoute[i];
			int to = travelRoute[i+1];
			totalNoTicket += noTicketCost[from][to];
			totalTicket += ticketCost[from][to];
		}
		
		System.out.println(totalNoTicket > totalTicket ? "Yes":"No");
		
	}
	
	static void floydWarshall(double[][] cost) {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				if(cost[i][k] == INF) continue;
				for(int j=0;j<N;j++) {
					if(cost[i][j]>cost[i][k]+cost[k][j]) {
						cost[i][j] = cost[i][k]+cost[k][j];
					}
				}
			}
		}
	}

}
