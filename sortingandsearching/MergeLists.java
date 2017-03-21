package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeLists {

	private MinHeap minHeap;
	private List resultList = new ArrayList();

	public MergeLists(List lists) {
		List result = new ArrayList();
		for (int i = 0; i < lists.size(); i++) {
			Object []temppList =  (Object[]) lists.get(i);
			for (int j = 0; j < temppList.length; j++) {
				result.add(temppList[j]);
			}
		}
		this.minHeap = new MinHeap(result.size(), result);
		this.minHeap.buildHeap();
	}

	public void merge() {
		while (!minHeap.isEmpty()) {
			int ele = (Integer) minHeap.deleteMin();
			resultList.add(ele);
		}
	}

	public void printList() {
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}

	class MinHeap<E extends Comparable<E>> {
		private List<E> elements;
		private int k;

		public MinHeap(int k, List<E> elements) {
			this.k = k;
			this.elements = elements;
		}

		public boolean isEmpty() {
			return k <= 0;
		}

		public void buildHeap() {
			for (int i = k / 2 - 1; i >= 0; i--) {
				heapify(i);
			}
		}

		public void heapify(int root) {
			int left = 2 * root + 1;
			int right = 2 * root + 2;
			int min = root;
			if (k > left
					&& elements.get(root).compareTo(elements.get(left)) > 0) {
				min = left;
			}
			if (k > right
					&& elements.get(root).compareTo(elements.get(right)) > 0) {
				min = right;
			}
			if (min != root) {
				swap(min, root);
				heapify(min);
			}
		}

		private void swap(int min, int root) {
			E temp = elements.get(min);
			elements.set(min, elements.get(root));
			elements.set(root, temp);

		}

		public void insert(E e) {
			elements.add(k++, e);
			int parent = (k - 1) / 2;
			int i = k - 1;
			while (parent >= 0
					&& elements.get(parent).compareTo(elements.get(i)) > 0) {
				swap(parent, i);
				i = parent;
				parent = (i - 1) / 2;
			}
		}

		public E deleteMin() {
			swap(0, k - 1);
			k--;
			heapify(0);
			E e = elements.get(k);
			elements.remove(k);
			return e;
		}
	}

	public static void main(String[] args) {
		List l1 = new ArrayList();
		l1.add(2);
		l1.add(5);
		l1.add(7);
		l1.add(9);
		l1.add(11);

		List l2 = new ArrayList();
		l2.add(1);
		l2.add(4);
		l2.add(6);

		List l3 = new ArrayList();
		l3.add(8);
		l3.add(12);

		List lists = new ArrayList();
		lists.add(l1.toArray());
		lists.add(l2.toArray());
		lists.add(l3.toArray());
		MergeLists ml = new MergeLists(lists);
		ml.merge();
		ml.printList();

	}
}
