package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * ZigZag traversal of a tree.
 * Print one level from left to right, and the next level from right to left and so on
 */ 

public class ZigZag {


/*
 * Create a queue and start with the root node in it
 * if the current size of the queue is x, pop x elements from the queue
 * for every node that you pop, add it to an array list from left to right or right to left
 * Also add their children to the queue
 * After you have poped x elements from the queue, you only have the nodes at the next level in the queue
 * repeat the above steps, swap the order in which you add to the array list.
 */

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean order = true;
		int size = 1;

		while(!q.isEmpty()) {
                // read all elements in current level, add them to array list
			List<Integer> tmp = new ArrayList<>();
			for(int i = 0; i < size; ++i) {
				TreeNode n = q.poll();
				if(order) {
					tmp.add(n.val);
				} else {
					tmp.add(0, n.val);
				}
                 // these are nodes of the next level; we don't read them yet
				if(n.left != null) q.add(n.left);
				if(n.right != null) q.add(n.right);
			}
                // get ready to do the same on the next level
			res.add(tmp);
			size = q.size();
			order = order ? false : true;
		}
		return res;
	}
}
