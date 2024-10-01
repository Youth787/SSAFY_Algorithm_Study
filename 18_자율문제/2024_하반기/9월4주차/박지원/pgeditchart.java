//프로그래머스 표편집 자바
//class안에서 움직임 나타내기

import java.util.Stack;

public class Solution {
    private static char UP = 'U';
    private static char DOWN = 'D';
    private static char CLEAR = 'C';
    private static char RESTORE = 'Z';
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> deletedRows = new Stack<>();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            if (i == 0) {
                continue;
            }
            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }
        Node current = nodes[k];

        for (String command : cmd) {
            char operation = command.charAt(0);

            switch (operation) {
                case UP:
                    int movement = Integer.parseInt(command.split(" ")[1]);
                    current = current.movePrev(movement);
                    break;
                case DOWN:
                    movement = Integer.parseInt(command.split(" ")[1]);
                    current = current.moveNext(movement);
                    break;
                case CLEAR:
                    deletedRows.add(current);
                    current = current.delete();
                    break;
                case RESTORE:
                    Node node = deletedRows.pop();
                    node.restore();
                    break;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodes[i].removed) {
                answer.append("X");
                continue;
            }
            answer.append("O");
        }

        return answer.toString();
    }

    class Node {
        Node prev = null;
        Node next = null;
        boolean removed;

        public Node movePrev(int movement) {
            Node node = this;
            for (int i = 0; i < movement; i++) {
                node = node.prev;
            }

            return node;
        }

        public Node moveNext(int movement) {
            Node node = this;
            for (int i = 0; i < movement; i++) {
                node = node.next;
            }

            return node;
        }

        public Node delete() {
            this.removed = true;
            Node prev = this.prev;
            Node next = this.next;

            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
                return next;
            }

            return prev;
        }

        public void restore() {
            this.removed = false;
            Node prev = this.prev;
            Node next = this.next;

            if (prev != null) {
                prev.next = this;
            }

            if (next != null) {
                next.prev = this;
            }
        }
    }
}
