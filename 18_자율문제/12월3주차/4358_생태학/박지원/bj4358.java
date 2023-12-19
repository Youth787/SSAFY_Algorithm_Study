import java.io.*;
import java.util.LinkedList;
import java.util.*;
import java.util.StringTokenizer;

//너무 어렵다..
//https://propercoding.tistory.com/92
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String s;
        int cnt = 0;
        while ((s = br.readLine()) != null) {
            cnt++;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
      //map의 정렬을 위해 list를 생성한다.
        List<String> list = new ArrayList<>();
      //List<String> list = new ArrayList<>(map.keySet()); 아래 4줄보다 이 코드가 나을듯
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String tree = entry.getKey();
            list.add(tree);
        }
      //정렬해준다.
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String tree: list) {
            int count = map.get(tree) * 100;
            sb.append(tree + " " + String.format("%.4f", (double)count / (double)cnt) + "\n");
        }
        System.out.println(sb);
    }
}

//입력받을때, 들어오는갯수를 모른다 ?
// while문으로 br.readLine() != null을 해주면 해결!!

//map함수를 정렬할 때는 그냥 ArrayList를 만들어서 넣어준 후, 그걸 정렬시키고 찾는 방법으로 해야함

//소수 자리 3자리 구하려면 ? 
//String.format("%.4f", number); 이렇게!! printf와 결이 약간 비슷하다!!

