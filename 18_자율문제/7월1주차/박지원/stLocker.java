//소프티어 금고 털이 
//dp로 풀다가 대패를 맛보다

import java.io.*;
import java.util.*;

public class Main {

    static class Metal implements Comparable<Metal> {
            int weight;
            int price;
            public Metal(int weight, int price) {
                this.weight = weight;
                this.price = price;
            }
        @Override
        public int compareTo(Metal m) {
            return m.price - this.price;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<Metal> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new Metal(m, p));
        }
        Collections.sort(list);
        
        long totalPrice = 0;
        long totalWeight = 0;
        for (Metal m: list) {
            if (totalWeight + m.weight <= w) {
                totalWeight += m.weight;
                totalPrice += m.price * m.weight;
            } else {
                totalPrice += m.price * (w - totalWeight);
                break;
            }
        }
        System.out.println(totalPrice);
    }
}

