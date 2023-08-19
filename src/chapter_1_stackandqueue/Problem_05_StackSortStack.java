package chapter_1_stackandqueue;

import java.util.Stack;

// https://www.nowcoder.com/practice/1de82c89cc0e43e9aa6ee8243f4dbefd?tpId=101&tqId=33075&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E6%A0%88
public class Problem_05_StackSortStack {

    public static void sortStackByStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        Stack<Integer> stackHelp = new Stack<>();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            while (!stackHelp.isEmpty() && num > stackHelp.peek()) {
                stack.push(stackHelp.pop());
            }
            stackHelp.push(num);
        }

        while (!stackHelp.isEmpty()) {
            stack.push(stackHelp.pop());
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        sortStackByStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
