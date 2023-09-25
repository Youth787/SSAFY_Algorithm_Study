import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (list.contains(s)) {
				list.remove(s);
			}
			list.add(s);
		} // 겹치는게 있으면 리스트에서 제거하면서 담기

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) 
					return o1.compareTo(o2); // 문자열비교. 오름차순 사전순.
				return o1.length() - o2.length(); // 길이에 대한 오름차순 
				// 양수값이 나오면 swap한다.
			}
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
