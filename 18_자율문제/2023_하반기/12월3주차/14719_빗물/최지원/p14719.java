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
        
        //블록마다 계산(가장자리 친구들은 물이 고일 수가 없다
        for (int i = 1; i < blocks.length - 1; i++) {
            int block = blocks[i];//현재 블록 높이
            
            //현재 블록 기준으로 왼쪽, 오른쪽을 구분하여 배열로 복사하고 -> 왼쪽의 높은 블록, 오른쪽 높은 블록 찾음 -> 둘 중 낮은 곳-현재 높이 차 만큼 cnt+
            int[] left = Arrays.copyOfRange(blocks, 0, i);
            int[] right = Arrays.copyOfRange(blocks, i + 1, blocks.length);
            Arrays.sort(left);
            Arrays.sort(right);
            int maxL = left[left.length-1];
            int maxR = right[right.length-1];
            /*32~35 줄 이걸로도 사용 가능..배열을 가져와 이를 스트림(Stream)으로 만들고, max()로 OptionalInt를 반환, 다시 int로(getAsInt)
            int maxL = Arrays.stream(left).max().getAsInt();
            int maxR = Arrays.stream(right).max().getAsInt();
            */
            
            if (block < maxL && block < maxR) {
                cnt += Math.min(maxL - block, maxR - block);
            }
        }       
        return cnt;
    }//count메서드
}//class
