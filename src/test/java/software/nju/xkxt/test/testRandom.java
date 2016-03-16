package software.nju.xkxt.test;

import java.util.HashSet;
import java.util.Random;

public class testRandom {

	public static HashSet<Integer> randomSelect(int m, int n) {
		HashSet<Integer> userSet = new HashSet<Integer>();
		if (m < n)
			return userSet;
		Random random = new Random();
		while (userSet.size() < n) {
			userSet.add((random.nextInt(m)));
		}
		return userSet;

	}

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			HashSet<Integer> userSet = randomSelect(50, 2);
			for (Integer i1 : userSet) {
				System.out.print(i1 + ";");
			}
			System.out.println();
		}

	}

}
