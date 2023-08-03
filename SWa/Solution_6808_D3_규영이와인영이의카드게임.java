package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_6808_D3_규영이와인영이의카드게임{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; 
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int gyu[], iny[], win, lose, card[];
	static boolean visited[], input[];
	
	private static void recursion(int cnt, int flag) {
		if(cnt==9) {
			int g_score = 0;
			int i_score = 0;
			
			for (int i = 0; i < 9; i++) {
				if((gyu[i] - card[i]) > 0) g_score += gyu[i]+card[i]; 
				else if ((gyu[i] - card[i]) < 0) i_score += gyu[i]+card[i]; 
			}
			if (g_score > i_score) win ++;
			if (g_score < i_score) lose ++;
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if((flag & 1<<i) != 0) continue;

			card[cnt] = iny[i];
			recursion(cnt+1, flag | 1<<i);
			
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < T+1; i++) {
			
			int idx = 0;
			input = new boolean[19];
			card = new int[9]; // 조합할 카드 
			
			gyu = new int[9];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				gyu[j] = Integer.parseInt(st.nextToken());
				input[gyu[j]] = true;
			}
			iny = new int[9];
			for (int j = 1; j < 19; j++) {
				if(!input[j]) iny[idx++] = j;
			}
			
			visited = new boolean[9];
			win = 0; // 123123123
			lose = 0; //123123123
			
			recursion(0, 0);
			
			sb.append("#").append(i).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
}
