/*
 * Create a stack with push and pop methods. Pop shall return the most frequent element in the stack, and in case of a tie, return the
 * most recent element (like a regular stack). 
 * For example, push (1), push(1), push(3), push(3), push(7). 5 Consequtive pop() calls will return 3, 1, 7, 3, 1. 
 */
import java.util.*;

class FreqStack {
    int pushCount;
    PriorityQueue<Node> pq;
    Map<Integer, Integer> map;
    public FreqStack() {
        pushCount = 0;
        pq = new PriorityQueue<Node>(new NodeComparator());
        map = new HashMap<Integer, Integer>();
    }
    
    public void push(int x) {
        if (!map.containsKey(x)){
            map.put(x, 0);
        }
        map.put(x, map.get(x) + 1);
        Node n = new Node(x, map.get(x), pushCount++);
        pq.offer(n);
    }
    
    public int pop() {
        map.put(pq.peek().value, map.get(pq.peek().value) - 1);
        return pq.poll().value;
    }
    
    
    class Node{
        public int value;
        int freq;
        int pushIndex;
        public Node(int v, int f, int p){
            this.value = v;
            this.freq = f;
            this.pushIndex = p;
        }
    }
    
    class NodeComparator implements Comparator<Node>{
        public int compare(Node a, Node b){
            if (a.freq != b.freq) return b.freq -a.freq;
                    return b.pushIndex - a.pushIndex;

        }
    }
}
