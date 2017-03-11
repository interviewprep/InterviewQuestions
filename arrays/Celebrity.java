package arrays;

public class Celebrity {
	public static int find(boolean [][]inp) {
		int i=0,j=0;
		while (i < inp.length && j <inp.length) {
			if(inp[i][j]) i++;
			else j++;
		}	
		return i;
	}
}
