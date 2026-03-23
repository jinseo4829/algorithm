import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] visited = new boolean[100000 + 1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int count = bfs(N, M);

        System.out.println(count);

    }

    public static int bfs(int N, int M) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});
        visited[N] = true;

        while(!queue.isEmpty()) {

            int[] current = queue.poll();
            int cn = current[0];

            if(cn == M) {
                return current[1];
            }

            int[] nx = {cn - 1, cn + 1, cn * 2};

            for(int next : nx) {

                if(next < 0 || next > 100000) {
                    continue;
                }

                if(!visited[next]) {
                    queue.offer(new int[]{next, current[1] + 1});
                    visited[next] = true;
                }
            }
        }

        return -1;
    }

}