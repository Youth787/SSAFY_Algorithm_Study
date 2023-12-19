//?
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(string[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Float> map = new HashMap<>();//나무 종 이름, 나무 개수 저장

        float cnt = 0f;//== 0.0 (float 타입을 나타내는 접미사 f 또는 F)

        String str = "";

        while((str= br.readLine())!=null){
            map.put(str, map.getOrDefault(str,0f)+1f);//1f == 1.0
            cnt++;
        }


        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);//사전순으로 정렬

        for(String key : keys){
            System.out.print(key+" ");
            System.out.println(String.format("%.4f",map.get(key)/cnt*100));
            //key에 해당하는 value 가져와서, 소수점 넷째자리까지 반올림하겠다
            //cnt*100 해서 백분율로
        }
    }//main
}//class
