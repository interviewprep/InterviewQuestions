package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class EliminateInvalidParenthesis {
	public static String deleteInvalidParenthesis(String input) {
		Deque<Parenthesis> stack = new ArrayDeque<Parenthesis>();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '(') {
				Parenthesis p = Parenthesis.OPEN_PARA;
				p.index = i;
				stack.addFirst(p);
			} else if (ch == ')') {
				if (!stack.isEmpty() && stack.peekFirst() != Parenthesis.CLOSE_PARA) {
					stack.removeFirst();
				} else {
					Parenthesis p = Parenthesis.CLOSE_PARA;
					p.index = i;
					stack.addFirst(p);
				}
			}
		}
        System.out.println(stack);
		return null;
	}
	public static void main(String args[]) {
		deleteInvalidParenthesis("(()))()");
		
	}
}



enum Parenthesis {
	OPEN_PARA, CLOSE_PARA;
	int index;

	Parenthesis() {

	}

	void setPosition(int i) {
		index = i;
	}
	public String toString() {
		return this.name() + "*" + index;
	}

}
