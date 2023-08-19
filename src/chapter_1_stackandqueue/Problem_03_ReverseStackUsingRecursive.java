package chapter_1_stackandqueue;

import java.util.Stack;

// https://www.nowcoder.com/practice/1de82c89cc0e43e9aa6ee8243f4dbefd?tpId=101&tqId=33075&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E9%80%86%E5%BA%8F
public class Problem_03_ReverseStackUsingRecursive {

	public static void reverse(Stack<Integer> stack) {
		if (stack == null || stack.isEmpty()) {
			return;
		}

		int lastElement = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(lastElement);
	}

	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int top = stack.pop();
		if (stack.isEmpty()) {
			return top;
		}

		int lastElement = getAndRemoveLastElement(stack);
		stack.push(top);
		return lastElement;
	}

	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}

	}

}
