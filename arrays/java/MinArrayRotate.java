package arrays;

/*
 * Given a 2d matrix of who knows who, find the celebrity in the party.
 * The celebrity knows no-one in the party, while everyone knows the celebrity
 * 
 */

// For simplicity we assume no-one knows themselves
// if i knows j, i is not the celebrity, else j is not the celebrity!
public class MinArrayRotate {
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
	
	// {5, 6, 1, 7, 3}
	private static Range findNoScoreRange(int array[], int pos) {
		// if num is in score range
		if (array[pos] <= pos) {
			int out_pos = array[pos] - 1;
			int out_pos_times = pos - out_pos;
			return new Range(out_pos_times,pos);
		}
		return null;
		
	}
	
	public static void main(String args[]){
        int array[] = {5, 10, 7, 3, 1};
        System.out.println(findNoScoreRange(array, 4));
		
		}
	}

class Range {
	int start;
	int end;
	Range(int s, int e) {
		start = s;
		end = e;
	}
	public String toString() { 
		return start + "," + end;
		}
}
