
public int solution(int n, int[] stations, int w) {
    int answer = 0;
    int leftStart = 1;

    for (int sub : stations) {
        if (leftStart < sub - w) {
            int leftEnd = sub - w;

            int length = leftEnd - leftStart;

            int count = length / (w * 2 + 1);
            if (length % (w * 2 + 1) != 0)
                count++;

            answer += count;
        }

        leftStart = sub + w + 1;
    }

    if(stations[stations.length-1] + w < n){
        leftStart = stations[stations.length-1] + w + 1;

        int leftEnd = n + 1;

        int length = leftEnd - leftStart;

        int count = length / (w * 2 + 1);
        if (length % (w * 2 + 1) != 0)
            count++;

        answer += count;
    }

    return answer;
}
