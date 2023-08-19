package chapter_7_bitoperation;

// https://www.nowcoder.com/practice/26e46f1f5e0d48c4b9ba13fe3e8d0ec6?tpId=101&tqId=33216&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=k
public class Problem_06_KTimesOneTime {

	public static int onceNum(int[] arr, int k) {
		int[] resArray = new int[32];

		for (int num : arr) {
			int[] kSystemArray = getKSysNumFromNum(num, k);
			addKSystemArray(resArray, kSystemArray, k);
		}
		return getNumFromKSysNum(resArray, k);
	}

	private static int[] getKSysNumFromNum(int num, int k) {
		int[] res = new int[32];
		for (int i = 0; i < res.length; i++) {
			res[i] = num % k;
			num /= k;
		}
		return res;
	}

	private static void addKSystemArray(int[] resArray, int[] kSystemArray, int k) {
		for (int i = 0; i < resArray.length; i++) {
			resArray[i] = (resArray[i] + kSystemArray[i]) % k;
		}
	}

	private static int getNumFromKSysNum(int[] resArray, int k) {
		int res = 0;
		int temp = 1;
        for (int num : resArray) {
            res += temp * num;
            temp *= k;
        }
		return res;
	}

	public static void main(String[] args) {
		int[] test1 = { 1, 1, 1, 2, 6, 6, 2, 2, 10, 10, 10, 12, 12, 12, 6, 9 };
		System.out.println(onceNum(test1, 3));

		int[] test2 = { -1, -1, -1, -1, -1, 2, 2, 2, 4, 2, 2 };
		System.out.println(onceNum(test2, 5));

	}

}