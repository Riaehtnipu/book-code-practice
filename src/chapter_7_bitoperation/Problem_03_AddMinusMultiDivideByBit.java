package chapter_7_bitoperation;

// https://www.nowcoder.com/practice/7c478cdfbacb4fd38ca063aa2ac35b6f?tpId=101&tqId=33212&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E5%8A%A0%E5%87%8F
public class Problem_03_AddMinusMultiDivideByBit {

	public static int add(int a, int b) {
		int temp;
		while (b != 0) {
			temp = a ^ b;
			b = (a & b) << 1;
			a = temp;
		}
		return a;
	}

	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	public static int negNum(int n) {
		return add(~n, 1);
	}

	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) == 1) {
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}

	// 处理正数的情况
	public static int div(int a, int b) {
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;

		int res = 0;
		for (int i = 31; i > -1; i = minus(i, 1)) {
			if ((x >>> i) >= y) {
				res |= (1 << i);
				x = minus(x, (y << i));
			}
		}
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	private static boolean isNeg(int num) {
		return num < 0;
	}

	public static int divide(int a, int b) {
		if (b == 0) {
			throw new RuntimeException("divisor is 0");
		}

		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
			return -1;
		}

		if (a == Integer.MIN_VALUE) {
			int res = div(add(a, 1), b);
			return add(res, div(minus(a, multi(res, b)), b));
		}

		if (b == Integer.MIN_VALUE) {
			return 0;
		}

		return div(a, b);
	}

	public static void main(String[] args) {
		int a = (int) (Math.random() * 100000) - 50000;
		int b = (int) (Math.random() * 100000) - 50000;
		System.out.println("a = " + a + ", b = " + b);
		System.out.println(add(a, b));
		System.out.println(a + b);
		System.out.println("=========");
		System.out.println(minus(a, b));
		System.out.println(a - b);
		System.out.println("=========");
		System.out.println(multi(a, b));
		System.out.println(a * b);
		System.out.println("=========");
		System.out.println(divide(a, b));
		System.out.println(a / b);
		System.out.println("=========");

		a = Integer.MIN_VALUE;
		b = 32;
		System.out.println(divide(a, b));
		System.out.println(a / b);

	}

}
