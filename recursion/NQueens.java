package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	class Sloution{

		private void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, 
				String[] board, List<String[]> res) {
			if (r == board.length) res.add(board.clone());
			else {
				for (int c = 0; c < board.length; c++) {
					int id1 = r - c + board.length, id2 = 2*board.length - r - c - 1;
					if (!cols[c] && !d1[id1] && !d2[id2]) {
						char[] row = new char[board.length];
						Arrays.fill(row, '.'); row[c] = 'Q';
						board[r] = new String(row);
						cols[c] = true; d1[id1] = true; d2[id2] = true;
						helper(r+1, cols, d1, d2, board, res);
						cols[c] = false; d1[id1] = false; d2[id2] = false;
					}
				}
			}
		}

		public List<String[]> solveNQueens(int n) {
			List<String[]> res = new ArrayList<>();
			helper(0, new boolean[n], new boolean[2*n], new boolean[2*n], 
					new String[n], res);
			return res;
		}
	}
	class Solution1 {
		public List<List<String>> solveNQueens(int n) {//the rule is no same column, no same row, no same on diagonal. i+j!=level+index
			List<List<String>> result=new ArrayList<List<String>>();
			List<Integer> taken=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				taken.add(i,-1);
			}
			getNQueens(result,0,n,taken);
			return result;
		}
		public void getNQueens(List<List<String>> result, int level, int n, List<Integer> taken){
			if(level==n){
				List<String> board=new ArrayList<String>();
				for(int i=0;i<n;i++){
					StringBuilder s=new StringBuilder();
					for(int j=0;j<n;j++){
						s.append(".");
					}
					s.setCharAt(taken.get(i),'Q');
					board.add(s.toString());
				}
				result.add(board);
				return;
			}
			for(int i=0;i<n;i++){
				if(isValid(taken,level,n,i)){
					taken.set(level,i);
					getNQueens(result,level+1,n,taken);
					taken.set(level, -1);
				}
			}
		}
		public boolean isValid(List<Integer> taken, int level, int n, int index){
			for(int i=0;i<level;i++){
				if(taken.contains(index)||(taken.get(i)+i==level+index)||(taken.get(i)+level==i+index)){
					return false;
				}
			}
			return true;
		}
	}

}
