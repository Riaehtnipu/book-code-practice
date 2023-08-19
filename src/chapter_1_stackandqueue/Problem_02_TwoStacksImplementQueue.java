package chapter_1_stackandqueue;

import java.util.Stack;

// https://www.nowcoder.com/practice/6bc058b32ee54a5fa18c62f29bae9863?tpId=101&tqId=33074&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class Problem_02_TwoStacksImplementQueue {

	public static class TwoStacksQueue {

		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			this.stackPush = new Stack<>();
			this.stackPop = new Stack<>();
		}

		private void pushToPop() {
			// 注意不要漏了
			if (!stackPop.isEmpty()) {
				return;
			}

			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}

		public void add(int pushInt) {
			stackPush.push(pushInt);
			// 三个地方都可以用
			pushToPop();
		}

		public int poll() {
			if (stackPush.isEmpty() && stackPop.isEmpty()) {
				throw new RuntimeException("empty");
			}
			pushToPop();
			return stackPop.pop();
		}

		public int peek() {
			if (stackPush.isEmpty() && stackPop.isEmpty()) {
				throw new RuntimeException("empty");
			}
			pushToPop();
			return stackPop.peek();
		}
	}

	public static void main(String[] args) {
		TwoStacksQueue test = new TwoStacksQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
	}

}
