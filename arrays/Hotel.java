package arrays;

import java.util.Arrays;

public class Hotel implements Comparable<Hotel> {
	int start;
	int end;
	Hotel(int s, int e) {
		start=s;
		end=e;
	}

	public int compareTo(Hotel o) {
		return this.start - o.start;
	}

	public static int max(Hotel []array){
		Arrays.sort(array);
		int j =1;
		int max_count = 0;
		for (int i = 0; i<array.length; i++) {
			while (j<array.length && array[i].end > array[j].start) {
				j++;
			}
			System.out.println("i= " + i +"j= "+j);		
			if (max_count < (j-i)) {
				max_count = j-i;
			}
		}
		return max_count;
	}
}
