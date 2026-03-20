import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    int houseCount = dfs(i, j);
                    result.add(houseCount);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int num : result) {
            System.out.println(num);
        }
    }

    public static int dfs(int x, int y) {

        visited[x][y] = true;
        int count = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if(visited[nx][ny]) {
                continue;
            }

            if(map[nx][ny] == 0) {
                continue;
            }

            count += dfs(nx, ny);
        }

        return count;
    }

}