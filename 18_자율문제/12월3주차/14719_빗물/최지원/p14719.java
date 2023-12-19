import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(st.nextToken()); //세로
        int w = Integer.parseInt(st.nextToken()); //가로
        int[] blocks = new int[w];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(count(blocks));
    }//main
    
    private static int count(int[] blocks) {
        int cnt = 0; //고인물 cnt
        
        //블록마다 계산
        for (int i = 1; i < blocks.length - 1; i++) {
            int block = blocks[i];
            
            //현재 블록 기준 왼쪽의 높은 블록, 오른쪽 높은 블록 찾음->둘 중 낮은 곳-현재 높이 차 만큼 cnt+
            int[] left = Arrays.copyOfRange(blocks, 0, i);
            int[] right = Arrays.copyOfRange(blocks, i + 1, blocks.length);
            int maxL = Arrays.stream(left).max().getAsInt();
            int maxR = Arrays.stream(right).max().getAsInt();
            
            if (block < maxL && block < maxR) {
                cnt += Math.min(maxL - block, maxR - block);
            }
        }       
        return cnt;
    }//count메서드
}//class
