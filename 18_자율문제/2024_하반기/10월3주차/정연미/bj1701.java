package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 메모리 초과 문제 발생 
// kmp 알고리즘 사용해야한다. 
public class bj1701 {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result =0;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<input.length(); i++){
            String st = "";
            for(int j=i; j<input.length(); j++){
                st+=input.charAt(j);
                map.put(st,map.getOrDefault(st,0)+1);
            }
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value>=2&&result<key.length()) result = key.length();
        }

        System.out.println(result);
    }
}
