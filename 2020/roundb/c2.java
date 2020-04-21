import java.util.*;
import static java.lang.Math.abs;

/**
1
9(9(9(WWW)))

9
SSSEEE
N
N3(S)N2(E)N
2(3(NW)2(W2(EE)W))
S
2(S)
2(S)NN
2(SNN)
5(N)2(S)2(W)

 */
class Solution {

	private static int BORDER = 1_000_000_000;
	private static char[] p;
	private static int i;	

	private static long[] subProgram() {
		long x = 0, y = 0;
		for (; i < p.length; ++i) {
			int r = p[i] - '0';
			if (r >= 2 && r <= 9) {
                i+=2;
				long[] tmp = subProgram();
                x = (x+r*tmp[0])%BORDER;
                y = (y+r*tmp[1])%BORDER;
			} else if (p[i] == ')') {
				return new long[]{x, y};
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
		return new long[]{x, y};
	}
	
	private static long moveUp(long y) {
		if (y - 1 >= 0) {
			return y - 1;
		}
		return BORDER - 1;
	}
	
	private static long moveDown(long y) {
		if (y + 1 < BORDER) {
			return y + 1;
		}
		return 0;
	}
	
	private static long moveRight(long x) {
		if (x + 1 < BORDER) {
			return x + 1;
		}
		return 0;
	}
	
	private static long moveLeft(long x) {
		if (x - 1 >= 0) {
			return x - 1;
		}
		return BORDER - 1;
	}

	private static void solve(int t) {
		
		p = sc.next().toCharArray();
		i = 0;
		
		long[] ans = subProgram();
		
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



