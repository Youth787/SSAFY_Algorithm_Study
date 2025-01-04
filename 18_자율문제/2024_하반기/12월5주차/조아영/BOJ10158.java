import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
      
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
 
        int t = Integer.parseInt(br.readLine());
 
        p = w - Math.abs(w - (t+p) % (w*2));
        q = h - Math.abs(h - (t+q) % (h*2));
 
        System.out.printf("%d %d", p, q);
    }
}
