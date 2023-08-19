package chapter_7_bitoperation;

// https://www.nowcoder.com/practice/02ae5ccb63064bbdb2366417d8b70ff3?tpId=101&tqId=33211&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E4%B8%8D%E7%94%A8
public class Problem_02_GetMax {

	public static int flip(int sign) {
		return sign ^ 1;
	}

	private static int sign(int num) {
		return (num >> 31) & 1;
	}

	public static int getMax1(int a, int b) {
		int signC = sign(a - b);
		return flip(signC) * a + signC * b;
	}

	public static int getMax2(int a, int b) {
		int signA = sign(a);
		int signB = sign(b);
		int signC = sign(a - b);

		int diff = signA ^ signB;
		int same = flip(diff);

		int returnA = same * flip(signC) + diff * signB;

		return returnA * a + flip(returnA) * b;
	}

	public static void main(String[] args) {
		int a = -16;
		int b = 1;
		System.out.println(getMax1(a, b));
		System.out.println(getMax2(a, b));
		a = 2147483647;
		b = -2147480000;
		System.out.println(getMax1(a, b)); // wrong answer because of overflow
		System.out.println(getMax2(a, b));
	}

}
