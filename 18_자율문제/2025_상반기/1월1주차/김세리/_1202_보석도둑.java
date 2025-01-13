package _20250113;

import java.util.*;
import java.io.*;

public class _1202_보석도둑 {
	static class Jewel implements Comparable<Jewel>{
		int weight, value;
		public Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
		
		@Override
		public int compareTo(Jewel o) {
			// 무게 기준으로 오름차순 정렬
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewel[] jewels = new Jewel[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(weight,value);
		}
		
		int[] bags = new int[K];
		for(int i=0;i<K;i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jewels);
		Arrays.sort(bags);
		// 보석의 가격 기준 내림차순
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long totalValue = 0;
		int jewelIdx = 0;
		
		for(int i=0;i<K;i++) {
			int bagCapacity = bags[i];
			
			while(jewelIdx<N && jewels[jewelIdx].weight<=bagCapacity) {
				pq.add(jewels[jewelIdx].value);
				jewelIdx++;
			}
			
			if(!pq.isEmpty()) {
				totalValue += pq.poll();
			}
		}
		
		System.out.println(totalValue);
	}

}
