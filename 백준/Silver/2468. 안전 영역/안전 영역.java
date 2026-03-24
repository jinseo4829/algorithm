import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int maxHeight = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int answer = 0;

        for (int rain = 0; rain <= maxHeight; rain++) {

            visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > rain && !visited[i][j]) {
                        dfs(i, j, rain);
                        count++;
                    }
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int rain) {

        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            if (map[nx][ny] <= rain) {
                continue;
            }

            dfs(nx, ny, rain);
        }
    }
}