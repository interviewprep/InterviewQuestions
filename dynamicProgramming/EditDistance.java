package dynamicProgramming;

public class EditDistance {
	   public int minDistance(String word1, String word2) {
	        int m = word1.length();
	        int n = word2.length();
	        
	        int[][] distance = new int[m + 1][n + 1];
	        for(int i = 0; i <= m; i++)
	            distance[i][0] = i;
	        for(int i = 1; i <= n; i++)
	            distance[0][i] = i;
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                if(word1.charAt(i) == word2.charAt(j))
	                    distance[i + 1][j + 1] = distance[i][j];
	                else {
	                    int a = distance[i][j];
	                    int b = distance[i][j + 1];
	                    int c = distance[i + 1][j];
	                    distance[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
	                    distance[i + 1][j + 1]++;
	                }
	            }
	        }
	        return distance[m][n];
	   }
	   
	public static int editdist(String s1, String s2){
		
		if(s1.length()<s2.length()){
			String temp = s1;
			s1=s2;
			s1=temp;
		}
		
		int []distance = new int[s2.length()+1];
		int prei1j1;
		for(int i=0;i<=s2.length();i++) distance[i]=i;
		
		for(int i=1;i<=s1.length();i++){
			prei1j1 = distance[0];
			distance[0]=i;
			for(int j=1;j<=s2.length();j++){
				int prei1j=distance[j];
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					distance[j] = prei1j1;
				}
				else{
					distance[j] = 1+Math.min(distance[j], Math.min(distance[j-1],prei1j1));
				}
				prei1j1 = prei1j;
	
			}
		}
		return distance[s2.length()];
	}

}
