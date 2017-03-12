package sortingandsearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {
	public static class Point implements Comparable<Point> {
		private double x, y, z;

		public Point(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public double distance() { return Math.sqrt(x * x + y * y + z * z); }

		@Override
		public int compareTo(Point rhs) {
			return Double.compare(this.distance(), rhs.distance());
		}
		// @exclude
		// clang-format off
		@Override
		public String toString() { return "(" + x + "," + y + "," + z + ")"; }
		// clang-format on
		// @include
	}

	public static List<Point> findClosestKPoints(int k, Iterator<Point> points) {
		// maxHeap to store the closest k points seen so far.
		PriorityQueue<Point> maxHeap
		= new PriorityQueue<>(k, Collections.reverseOrder());
		while (points.hasNext()) {
			// Add each point to the max-heap. If the max-heap size exceeds k, remove
			// the maximum element from the max-heap.
			Point point = points.next();
			maxHeap.add(point);
			if (maxHeap.size() == k + 1) {
				maxHeap.remove();
			}
		}

		List<Point> orderedPoints = new ArrayList<Point>(maxHeap);
		// The only guarantee PriorityQueue makes about ordering is that the
		// maximum element comes first, so we sort orderedpoints.
		Collections.sort(orderedPoints);
		return orderedPoints;
	}

}
