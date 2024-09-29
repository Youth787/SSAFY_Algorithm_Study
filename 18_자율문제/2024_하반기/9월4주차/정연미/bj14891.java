package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// char to int
// input.charAt(j)-'0';
// Character.getNumericValue(input.charAt(j));
// Integer.parseInt(String.valueOf(input.charAt(j)));

// ArrayList<Integer>[] list = new ArrayList[i];
// gears[i].add(0, gears[i].get(7)); // 7번째 index 위치의 값을 index 0 위치에 추가한다.

public class bj14891 {
    static ArrayList<Integer>[] gears = new ArrayList[4];
    static int[] gear_dir = new int[4];
    static int score = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            gears[i] = new ArrayList<>();
            for (int j = 0; j < 8; j++)
                gears[i].add(input.charAt(j) - '0');
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            Arrays.fill(gear_dir, 0); // 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            gear_dir[number] = direction;
            right(number);
            left(number);

            for (int p = 0; p < 4; p++) {
                if (gear_dir[p] == 1) turn_right(p);
                else if (gear_dir[p] == -1) turn_left(p);
            }
        }

        sumscore();
        System.out.println(score);
    }

    public static void left ( int number){
        if (number == 0) return;
        if (gears[number - 1].get(2) != gears[number].get(6)) {
            if (gear_dir[number]==1) gear_dir[number-1] = -1;
            else if(gear_dir[number]==-1) gear_dir[number-1] = 1;
            left(number-1);
        }
    }
    public static void right (int number){
        if(number==3) return;
        if(gears[number].get(2)!=gears[number+1].get(6)){
            if(gear_dir[number]==1) gear_dir[number+1]= -1;
            else if(gear_dir[number] == -1) gear_dir[number+1] = 1;
            right(number+1);
        }
    }
    public static void turn_right (int gear){
        gears[gear].add(0,gears[gear].get(7));
        gears[gear].remove(8);
    }
    public static void turn_left ( int gear){
        gears[gear].add(gears[gear].get(0));
        gears[gear].remove(0);
    }
    public static void sumscore() {
        for(int i=0; i<4; i++){
            int num = gears[i].get(0);
            if(num ==1) score+= Math.pow(2,i);
        }
    }
}

