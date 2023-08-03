package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_G4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, count;
	static int max = 0;
	static String[] word;
	static boolean visited[] = new boolean[26];

 
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new String[N];
		
		// 만약 해당 알파 벳이 5이하이면 아무 단어도 만족시킬 수가 없으며,
		// 26이면 모든 알파벳을 사용하기 때문에 모두 만들 수 있음
		// 만약 둘 다 해당되지 않는 경우에는 'anta' / 'tica'를 제외한 단어를 word에 저장
		if (K < 5) {
			System.out.println(0);
			return;
		} else if (K == 26) {
			System.out.println(N);
			return;
		} else {
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				word[i] = str.substring(4, str.length() - 4);
			}
			
			// visited에서 해당 언어를 방문 처리한다. 
			visited['a' - 97] = true;
			visited['n' - 97] = true;
			visited['t' - 97] = true;
			visited['i' - 97] = true;
			visited['c' - 97] = true;
			
			// 함수 실행
			combination(0, 0);
			System.out.println(max);
		}
	}
	
	// 조합 함수
	private static void combination(int idx, int start) {
		
		// 만약 K-5개의 알파 벳 배열이 완료가 되면, 검사해준다.
		if (idx == K - 5) {
			int count = 0;
			
			// 단어마다 반복문을 돌면서 확인한다. 
			for (int i = 0; i < N; i++) {
				boolean possible = true;
				
				// 단어의 문자 하나하나 확인하고.
				// 만약의 visited 배열에 해당 단어가 없으면 이 단어는 만들 수 없는 단어
				// possible 을 false로 만들고 함수를 종료한다.
				for (int j = 0; j < word[i].length(); j++) {
					if (!visited[word[i].charAt(j) - 97]) {
						possible = false;
						break;
						
					}
				}
				// 만약 이 visited로 만들 수 있다면 하나를 더해준다.
				if (possible)
					count++;
			}
			// 최댓값을 비교해준다.
			max = Math.max(max, count);
			return;
		}

        // 알파 벳의 갯수 만큼의 조합을 만든다
		for (int i = start; i < 26; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(idx + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}
