package chapter_1_stackandqueue;

import java.util.Stack;

// https://www.nowcoder.com/practice/05e57ce2cd8e4a1eae8c3b0a7e9886be?tpId=101&tqId=33073&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class Problem_01_GetMinStack {

	public static class MyStack1 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack1() {
			this.stackData = new Stack<>();
			this.stackMin = new Stack<>();
		}

		public void push(int newNum) {
			stackData.push(newNum);
			if (stackMin.isEmpty() || newNum <= stackMin.peek()) {
				stackMin.push(newNum);
			}
		}

		public int pop() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("empty");
			}

			int num = stackData.pop();
			// 没有null？
			if (stackMin.peek() == num) {
				stackMin.pop();
			}
			return num;
		}

		public int getmin() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("empty");
			}
			return stackMin.peek();
		}
	}

	public static class MyStack2 {

		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack2() {
			this.stackData = new Stack<>();
			this.stackMin = new Stack<>();
		}

		public void push(int newNum) {
			stackData.push(newNum);
			if (stackMin.isEmpty() || newNum <= stackMin.peek()) {
				stackMin.push(newNum);
			} else {
				stackMin.push(stackMin.peek());
			}
		}

		public int pop() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("empty");
			}
			stackMin.pop();
			return stackData.pop();
		}

		public int getmin() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("empty");
			}
			return stackMin.peek();
		}
	}

	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(3);
		System.out.println(stack1.getmin());
		stack1.push(4);
		System.out.println(stack1.getmin());
		stack1.push(1);
		System.out.println(stack1.getmin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getmin());

		System.out.println("=============");

		MyStack1 stack2 = new MyStack1();
		stack2.push(3);
		System.out.println(stack2.getmin());
		stack2.push(4);
		System.out.println(stack2.getmin());
		stack2.push(1);
		System.out.println(stack2.getmin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getmin());
	}

}
