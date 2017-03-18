package dynamicProgramming;

public class Fibanocci {
	int fibmem(int n) {
		if(n<=2) return 1;
		int []result = new int[n];
		result[0]=1;result[1]=1;
		for (int i = 2; i < n; i++) {
			result[i] = result[i-1] + result[i-2];
		}
		return result[n-1];
	}
	int fib(int n) {
		int prev=1,current=1,next=1,i=3;
		while(i<=n) {
			next = current+prev;
			prev=current;
			current = next;
			i++;
		}
		return next;
	}
}
