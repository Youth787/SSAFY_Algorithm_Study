import java.util.HashSet;
import java.util.Set;

public static int solution(int N, int number) {
    int answer = -1;
    int now = N;
    Set<Integer>[] setArr = new HashSet[9];
    for(int i=1;i<9;i++) {
        setArr[i] = new HashSet<>();
        setArr[i].add(now);
        now = now*10 + N;
    }

    for(int i=1;i<9;i++) {
        for(int j=1;j<i;j++) {
            for(Integer a : setArr[j]) {
                for(Integer b : setArr[i-j]) {
                    setArr[i].add(a+b);
                    setArr[i].add(a-b);
                    setArr[i].add(b-a);
                    setArr[i].add(a*b);
                    if(a!=0) {
                        setArr[i].add(b/a);
                    }
                    if (b!=0) {
                        setArr[i].add(a/b);
                    }
                }
            }
        }
    }

    for(int i=1;i<9;i++) {
        if(setArr[i].contains(number)) {
            answer = i;
            break;
        }
    }
    return answer;
}
