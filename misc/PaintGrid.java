package misc;

// Leetcode 1411

//
// You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colours:
// Red, Yellow or Green while making sure that no two adjacent cells have the same colour 
// (i.e no two cells that share vertical or horizontal sides have the same colour).

public class PaintGrid {

	public static int numOfWays(int n) {
		// for row 1, there are 6 bi colored rows and 6 tri colored rows.
		long bi_rows = 6;
		long tri_rows = 6;

		int divisor = (int) (Math.pow(10, 9) + 7);

		for (int i = 1; i < n; i++) {
			// every bi row results in two tri rows and 3 bi rows. 
			// every tri row results in two tri rows and two bi rows. 
			long new_tri_rows = (tri_rows * 2) % divisor + (bi_rows * 2) % divisor;
			long new_bi_rows = (bi_rows * 3) % divisor + (tri_rows * 2) % divisor;
			bi_rows = new_bi_rows;
			tri_rows = new_tri_rows;
		}

		long result = bi_rows + tri_rows;
		// return result;

		return (int) (result % divisor);
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println("The number of ways to paint " + n + " is " + numOfWays(n));

	}

}
