import java.io.*;
import java.util.*;

public class Main {

    static int F, S, G, U ,D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int count = bfs(F, S, G, U, D);

        if(count == -1) {
            System.out.println("use the stairs");
        }else {
            System.out.println(count);
        }
    }

    public static int bfs(int total, int now, int target, int up, int down) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{now, 0});
        visited = new boolean[total + 1];
        visited[now] = true;

        while(!queue.isEmpty()) {

            int[] current = queue.poll();
            int n = current[0];

            if(n == target) {
                return current[1];
            }

            int[] nn = new int[]{n + up, n - down};

            for(int next : nn) {

                if(next < 1 || next > total) {
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