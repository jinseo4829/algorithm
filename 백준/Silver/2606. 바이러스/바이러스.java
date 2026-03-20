import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i=1; i<= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.println(count - 1);
    }

    static void dfs(int node) {
        visited[node] = true;
        count++;

        for(int next : graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

}