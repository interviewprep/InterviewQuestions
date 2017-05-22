package sortingandsearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

public class MergeArrays {
	// Number of Arrays
	private static final int N = 3;
	// Stores Arrays into Map with id(rank) and Array object as key value pairs
	private static HashMap<Integer, ArrayList<Integer>> arrayMap = new HashMap<Integer, ArrayList<Integer>>();

	private static int TOTAL = 0;

	public static void main(String[] args) {
		createArrays();
		System.out.println("Number of arrays: " + N);
		printArrays();
		ArrayList<Integer> mergedList = mergeArrays();
		System.out.println("Final merged lists data: ");
		printMergedList(mergedList);
		System.out.println();

	}

	public static void printMergedList(ArrayList<Integer> mergedList) {
		if (mergedList == null || mergedList.size() < 1) {
			System.out.println("Merged List is EMPTY!");
		}
		Iterator<Integer> iter = mergedList.iterator();

		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> mergeArrays() {
		// resultant merged arraylist
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		Set<Integer> keySet = arrayMap.keySet();
		// Creating custom comparator
		Comparator<Node> comparator = new NumericComparator();
		// PriorityQueue for retrieving MinValue
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(TOTAL, comparator);

		Iterator<Integer> iter = keySet.iterator();
		// Initialize priority queue with one element from each array set
		while (iter.hasNext()) {
			int key = iter.next();
			ArrayList<Integer> list = arrayMap.get(key);
			if (list != null) {
				Integer data = list.remove(0);
				// create Node object with Data and key as parameters.
				Node node = new Node(data, key);
				minHeap.add(node);
			}
		}
		// loop through until all elements are removed from PriorityQueue
		while (minHeap.size() > 0) {
			// remove MinElement from the Queue
			Node node = minHeap.remove();
			// System.out.print(node.data + " ");
			// add the Min Value to resultant array
			mergedList.add(node.data);
			// identifer(id) of current array set to get next element
			int id = node.id;
			ArrayList<Integer> list = arrayMap.get(id);
			if (list != null && list.size() > 0) {
				Integer data = list.remove(0);
				Node newNode = new Node(data, id);
				// add Node data to the PriorityQueue
				minHeap.add(newNode);
			}
		}

		return mergedList;

	}

	/**
	 * Utility to create 'N' arrays
	 */
	public static void createArrays() {
		Random rand = new Random();
		for (int i = 0; i < N; i++) {
			int size = rand.nextInt(5) + 5;
			TOTAL += size;
			ArrayList<Integer> numList = new ArrayList<>();
			for (int j = 0; j < size; j++) {
				int value = rand.nextInt(1000) + 1;
				numList.add(value);
			}
			Collections.sort(numList);
			arrayMap.put(i + 1, numList);
		}
	}

	/**
	 * Utility to print Arrays
	 */
	public static void printArrays() {
		Iterator it = arrayMap.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, ArrayList<Integer>> pair = (Map.Entry<Integer, ArrayList<Integer>>) it
					.next();
			ArrayList<Integer> list = pair.getValue();
			Iterator liter = list.iterator();
			while (liter.hasNext()) {
				System.out.print(liter.next() + " ");
			}
			System.out.println();
		}
	}
}

/**
 * custom ADT to hold data and id
 * 
 * 
 */
class Node {
	int data;
	// ID is used as identifier(index) for uniquely distinguishing different
	// arrays to find it's associated elements
	int id;

	Node(int data, int id) {
		this.data = data;
		this.id = id;
	}
}

/**
 * Custom comparator for comparing two values
 * 
 */
class NumericComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.data < o2.data) {
			return -1;
		} else if (o1.data > o2.data) {
			return 1;
		}
		return 0;
	}

}
