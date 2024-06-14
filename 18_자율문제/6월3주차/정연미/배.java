package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> crain = new ArrayList<>();
        for(int i=0; i<N; i++) crain.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) boxes.add(Integer.parseInt(st.nextToken()));

        crain.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if(boxes.get(0)>crain.get(0)){
            System.out.println(-1);
            return;
        }

        int result=0;
        while (!boxes.isEmpty()) {
            int boxIndex = 0; int crainIndex =0;
            while (crainIndex <N) {
                if (boxIndex == boxes.size()) break;
                else if (crain.get(crainIndex) >= boxes.get(boxIndex)) {
                    boxes.remove(boxIndex);
                    crainIndex++;
                } else
                    boxIndex++;
            }
            result++;
        }
        System.out.println(result);
    }
}
