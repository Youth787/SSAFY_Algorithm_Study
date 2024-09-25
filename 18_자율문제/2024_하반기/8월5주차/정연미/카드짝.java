
//다시풀기
import java.util.LinkedList;
import java.util.Queue;
class Solution {
 static Queue<Card> q;

    static int map[][];
    static boolean isIn[];
    static boolean isEat[];
    static boolean visit[][];
    static int select[];

    static int dy[] = { 0, 1, 0, -1 };
    static int dx[] = { -1, 0, 1, 0 };
    static int sx, sy, duo;
    static int res;

    public static boolean isSafe(int y, int x) {
        if (y >= 4 || x >= 4 || y < 0 || x < 0)
            return false;
        return true;
    }

    public static class Card {
        int y, x;
        int dist;

        public Card(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

    }

    public static int solution(int[][] board, int r, int c) {
        sy = r;
        sx = c;

        duo = 0;
        isIn = new boolean[6 + 1];
        map = board.clone();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] > 0) {
                    if (!isIn[map[i][j]]) {
                        isIn[map[i][j]] = true;
                        duo++;
                    } else {
                        map[i][j] += 6;
                    }

                }
            }
        }
        select = new int[duo];
        res = Integer.MAX_VALUE;
        permu(0);
        return res;
    }

    private static void permu(int cnt) {
        if (cnt == duo) {// 카드 순서 정립시
            Card c = new Card(sy, sx, 0);
            isEat = new boolean [13];
            for (int i = 0; i < cnt; i++) {
                c = find(select[i] + 6, find(select[i], c));
            }
            res = Math.min(res, c.dist);
            return;
        }
        for (int i = 1; i < 7; i++) {
            if (isIn[i]) {
                isIn[i] = false;
                for (int k = 0; k < 2; k++) {
                    select[cnt] = i + (6 * k);
                    permu(cnt + 1);
                }
                isIn[i] = true;
            }
        }

    }

    private static Card find(int next, Card card) {
        if (next > 12)
            next -= 12;

        q = new LinkedList<>();
        visit = new boolean[4][4];
        visit[card.y][card.x] = true;

        q.add(card);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Card p = q.poll();
                if (next == map[p.y][p.x]) {
                    p.dist += 1;
                    isEat[next] = true;
                    return p;
                }

                for (int d = 0; d < 4; d++) {// 한칸이동
                    int jy = p.y + dy[d];
                    int ix = p.x + dx[d];
                    if (!isSafe(jy, ix) || visit[jy][ix])
                        continue;
                    visit[jy][ix] = true;
                    q.add(new Card(jy, ix, p.dist + 1));
                }

                for (int d = 0; d < 4; d++) {// 끝까지 이동
                    int jy = p.y;
                    int ix = p.x;

                    while (isSafe(jy + dy[d], ix + dx[d])) {
                        jy += dy[d];
                        ix += dx[d];
                        if (map[jy][ix] > 0 && !isEat[map[jy][ix]])
                            break;

                    }
                    if (visit[jy][ix])
                        continue;
                    visit[jy][ix] = true;
                    q.add(new Card(jy, ix, p.dist + 1));
                }

            }
        }
        return card;
    }
}
