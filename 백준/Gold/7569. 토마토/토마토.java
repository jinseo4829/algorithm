import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static int[] dh = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for(int h=0; h<H; h++) {
            for(int x=0; x<N; x++) {

                st = new StringTokenizer(br.readLine());
                for(int y=0; y<M; y++) {
                    int node = Integer.parseInt(st.nextToken());
                    box[h][x][y] = node;

                    if(node == 1) {
                        queue.offer(new int[]{h, x, y});
                    }
                }
            }
        }

        bfs();

        int answer = 0;

        for(int h=0; h<H; h++) {
            for(int x=0; x<N; x++) {
                for(int y=0; y<M; y++) {

                    if(box[h][x][y] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    answer = Math.max(answer, box[h][x][y]);

                }
            }
        }

        System.out.println(answer -1);

    }

     public static void bfs() {

        while(!queue.isEmpty()) {

            int[] current = queue.poll();
            int ch = current[0];
            int cx = current[1];
            int cy = current[2];

            for(int d=0; d<6; d++) {

                int nh = ch + dh[d];
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nh < 0 || nx < 0 || ny < 0 || nh >= H || nx >= N || ny >= M) {
                    continue;
                }

                if(box[nh][nx][ny] != 0) {
                    continue;
                }

                box[nh][nx][ny] = box[ch][cx][cy] + 1;
                queue.offer(new int[]{nh, nx, ny});
            }
        }
     }

}