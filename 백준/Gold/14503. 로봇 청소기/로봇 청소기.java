import java.io.*;
import java.util.*;

public class Main {

    static int N, M, r, c, d;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while(true) {

            if(map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }

            boolean hasEmpty = false;
            for(int i=0; i<4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];

                if(map[nx][ny] == 0) {
                    hasEmpty = true;
                    break;
                }
            }

            if(!hasEmpty) {
                int back = (d + 2) % 4;
                int brx = r + dx[back];
                int bry = c + dy[back];

                if(map[brx][bry] == 1) {
                    break;
                } else {
                    r = brx;
                    c = bry;
                }
            }

            if(hasEmpty) {
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                }
            }
        }

        System.out.println(count);
    }

}