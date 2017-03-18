package dynamicProgramming;

public class CoinChange {
	public static int ways(int[]d, int target){
		int []res = new int[target+1];
		res[0]=1;
		for (int i = 0; i < d.length; i++) {
			for (int j = d[i]; j <res.length; j++) {
				res[j]+=res[j-d[i]];
			}
		}
		return res[target];
	}

}
