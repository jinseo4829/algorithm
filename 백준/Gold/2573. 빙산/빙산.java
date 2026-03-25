import java.io.*;
import java.util.*;

public class Main {

    static int N, M, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        
        while(true) {

            visited = new boolean[N][M];
            countIceberg();

            if(count >= 2) {
                System.out.println(year);
                return;
            }

            if(count == 1) {
                melt();
            }

            if(count == 0) {
                System.out.println(0);
                return;
            }
            
            year++;
        }

    }

    public static void melt() {

        int[][] mapsum = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {

                int sum = 0;

                if(map[i][j] != 0) {

                    for(int d=0; d<4; d++) {

                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                            continue;
                        }

                        if(map[nx][ny] == 0) {

                            sum++;
                        }
                    }

                    mapsum[i][j] = sum;

                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] < mapsum[i][j]) {
                    map[i][j] = 0;
                } else {
                    map[i][j] -= mapsum[i][j];
                }
            }
        }
    }

    public static void countIceberg() {

        count = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {

                if(map[i][j] != 0 && !visited[i][j]) {

                    dfs(i, j);
                    count++;
                }
            }
        }
    }

    public static void dfs(int x, int y) {

        visited[x][y] = true;

        for(int d=0; d<4; d++) {

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if(map[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }

            dfs(nx, ny);
        }
    }


}