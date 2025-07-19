import java.util.*;

public class KnightWalk {

    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{KnightPos[0], KnightPos[1], 0});
        visited[KnightPos[0]][KnightPos[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            if (x == TargetPos[0] && y == TargetPos[1]) {
                return steps;
            }

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isValid(newX, newY, N) && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1; 
    }

    private static boolean isValid(int x, int y, int N) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

    public static void main(String[] args) {
        int N = 8; 
        int[] KnightPos = {4, 5};
        int[] TargetPos = {1, 1};

        int result = minStepToReachTarget(KnightPos, TargetPos, N);
        System.out.println("Minimum steps: " + result);
    }
}
