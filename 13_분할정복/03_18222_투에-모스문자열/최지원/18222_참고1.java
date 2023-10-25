//풀이 https://velog.io/@jh5253/%EB%B0%B1%EC%A4%80-18222-%ED%88%AC%EC%97%90-%EB%AA%A8%EC%8A%A4-%EB%AC%B8%EC%9E%90%EC%97%B4-Java%EC%9E%90%EB%B0%94
//근데 진짜 모르겠음..

//문제 : 01 길이 무한한 문자열 x의 k번째에는 무슨 문자가 오는지
//처음 x = 0 -> 0은 1로&1은 0으로 바꾼 문자열을 만들고 -> x뒤에 이를 붙여서 새롭게 x정의 -> 반복
//k (1 ≤ k ≤ 10의 18승)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());//몇번째 값인지 나타내는 K
        map = new long[65];//map은 해당 시점의 자릿수를 담게됨
        map[0] = 1;//시작은 1자리(0)임
        for(int i = 1; i < 65; ++i) { 
            map[i] = map[i-1] * 2;//같은 길이를 뒤집어서 붙이니까 2배씩 늘어남
        }
        System.out.print(get(K));
    }//main

    //
    static long get(long k) {
        if(k == 1) return 0; //기저조건 : k가 최종적으로 1이 되었다면 0을 티런

        for(int i = 0; i < 65; ++i) { //0번째 인덱스부터 탐색하면서 현재 찾고자 하는 위치 k를 생성한 이전의 분자열 길이를 담은 map의 인덱스를 구함
            if(k <= map[i]) return 1- get(k - map[i-1]);//1에서 해당 값을 빼주는 이유는 해당 숫자를 반전시킨다는 뜻...
        }
        return 0;
    }//get
}//class
