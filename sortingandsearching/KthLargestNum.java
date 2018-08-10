package sortingandsearching;

public class KthLargestNum {
	
	public static int findKth(int nums[], int start, int end, int k) {
    if ( nums.length == 1)
    		return nums[0];
    //position of element at location 0
    int pos = getPosition(nums, start, end);
    if (pos == k )
    		return nums[pos];
    else if (pos < k  )
    		return findKth(nums, pos+1, end, k);
    else {  //pos > k
    		return findKth(nums, start, pos-1, k);
    }
	}
	public static void main(String args[]) {
		System.out.println(findKth(new int[]{1,2,3}, 0, 2, 1));
		System.out.println(findKth(new int[]{3,2,1}, 0, 2, 1));
		System.out.println(findKth(new int[]{1,2,3}, 0, 2, 1));
		System.out.println(findKth(new int[]{3,2,1}, 0, 2, 0));
		System.out.println(findKth(new int[]{3,2,3}, 0, 2, 0));
		System.out.println(findKth(new int[]{3,3,3}, 0, 2, 2));

	}
	private static int getPosition(int nums[], int start, int end) {
		// picking the start element as a pivot
		//  May result in O(n^2) time complexity in a sorted array.
		// to avoid this case, pick a random number as pivot.
		int pivot = nums[start];
		int i = start + 1;
		int j = end;
		while ( true) {
			while (i <= j && nums[i] < pivot)
				i++;
			while(j >i && nums[j] >= pivot)
				j--;
			if (i>=j)
				break;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		int temp = nums[i-1];
		nums[i-1] = nums[start];
		nums[start] = temp;
		return i-1;
	}

}
