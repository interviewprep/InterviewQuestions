package arrays;

/*
 * Given a 2d matrix of who knows who, find the celebrity in the party.
 * The celebrity knows no-one in the party, while everyone knows the celebrity
 * 
 */

// For simplicity we assume no-one knows themselves
// if i knows j, i is not the celebrity, else j is not the celebrity!
public class Celebrity {
	public static int find(boolean[][] inp) {
		int i = 0, j = 0;
		while (i < inp.length && j < inp.length) {
			if (inp[i][j])
				i++;
			else
				j++;
		}
		return i;
	}
}
