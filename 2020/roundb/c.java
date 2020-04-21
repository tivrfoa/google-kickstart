import java.util.*;

class Solution0 {

	private static int BORDER = 1_000_000_000;
	private static char[] p;

	private static int[] subProgram(int x, int y, int i) {
		for (; i < p.length; ++i) {
			int r = p[i] - '0';
			if (r >= 2 && r <= 9) {
				i += 2;
				int ni = 0;
				for (int j = 0; j < r; ++j) {
					int[] tmp = subProgram(x, y, i);
					x = tmp[0];
					y = tmp[1];
					ni = tmp[2];
				}
				i = ni;
			} else if (p[i] == ')') {
				return new int[]{x, y, i};
			} else {
				switch(p[i]) {
					case 'N':
						y = moveUp(y);
						break;
					case 'S':
						y = moveDown(y);
						break;
					case 'E':
						x = moveRight(x);
						break;
					case 'W':
						x = moveLeft(x);
						break;
					default:
						System.err.println("WRONGGGGGG");
						System.exit(-1);
				}
			}
		}
		return new int[]{x, y, i};
	}
	
	private static int moveUp(int y) {
		if (y - 1 >= 0) {
			return y - 1;
		}
		return BORDER - 1;
	}
	
	private static int moveDown(int y) {
		if (y + 1 < BORDER) {
			return y + 1;
		}
		return 0;
	}
	
	private static int moveRight(int x) {
		if (x + 1 < BORDER) {
			return x + 1;
		}
		return 0;
	}
	
	private static int moveLeft(int x) {
		if (x - 1 >= 0) {
			return x - 1;
		}
		return BORDER - 1;
	}

	private static void solve(int t) {
		
		p = sc.next().toCharArray();
		
		int[] ans = subProgram(0, 0, 0);
		
		System.out.printf("Case #%d: %d %d\n", t, ans[0]+1, ans[1]+ 1);
	}
	
	
	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		
		sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; ++t) {
			solve(t);
		}
		sc.close();
	}
}



