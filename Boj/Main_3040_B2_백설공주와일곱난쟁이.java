package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040_B2_백설공주와일곱난쟁이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] small;
	static boolean[] isSelected;
	static int[] nums = new int[7];
	
	public static void main(String[] args) throws IOException {
		small = new int[9];
		for(int i=0 ;i < 9; i++) {
			small[i] = stoi(br.readLine());
		}
		combination(0,0);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			int total = 0;
			for(int i=0 ; i< nums.length; i++)
				total += nums[i];
			if(total == 100) {
				for(int i=0 ; i< nums.length; i++)	
					System.out.println(nums[i]);	
			}
			return;
		}
		
		for(int i= start; i< small.length; i++) {
			nums[cnt] = small[i];
			combination(cnt+1, i+1);
		}
	}
	
	public static int stoi(String input) {
		return Integer.parseInt(input);
	}
}