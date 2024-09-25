import java.util.*;
 
public class Main {
 
    static int h, w;
    static int[] height;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        h = scan.nextInt();
        w = scan.nextInt();
 
        height = new int[w];
        for(int i = 0; i < w; i++) {
            height[i] = scan.nextInt();
        }
 
        int result = 0;
        for(int i = 1; i < w - 1; i++) { //인덱스 별 모이는 빗물. 첫, 마지막 제외
            int left = 0;
            int right = 0;
 
            for(int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }
 
            for(int j = i + 1; j < w; j++) {
                right = Math.max(height[j], right);
            }
 
            if(height[i] < left && height[i] < right) result += Math.min(left, right) - height[i];
        }
        System.out.println(result);
    }
}
