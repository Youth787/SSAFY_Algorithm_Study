import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
      
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
      
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num>0) q.add(num);
            else {
                if (!q.isEmpty()) System.out.println(q.poll());
                else System.out.println(0);
            }
        }
    }
}
