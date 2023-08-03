package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_G5_치킨배달_이동훈 {
	static int n, m;
	static int[][] map;
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> choice = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	static boolean[] visit;

	static void back(int depth, int start) {
		if (depth == m) {
			int sum = 0;
			for (int[] h : home) {
				int min = Integer.MAX_VALUE;
				for (int[] c : choice) {
					int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
					min = Math.min(d, min);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;

		}

		for (int i = start; i < chicken.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				choice.add(chicken.get(i));
				back(depth + 1, i + 1);

				choice.remove(choice.size() - 1);

				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		chicken.clear();
		home.clear();
		choice.clear();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home.add(new int[] { i, j });
				}

				if (map[i][j] == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}

		visit = new boolean[chicken.size()];

		back(0, 0);
		System.out.println(result);

	}

}