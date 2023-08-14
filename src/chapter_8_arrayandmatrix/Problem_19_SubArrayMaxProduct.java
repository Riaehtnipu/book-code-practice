package chapter_8_arrayandmatrix;

// https://www.nowcoder.com/practice/f46135ecf26a45b3b964239ebc745aac?tpId=101&tqId=33100&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E5%AD%90%E6%95%B0%E7%BB%84%E7%9A%84%E6%9C%80%E5%A4%A7
public class Problem_19_SubArrayMaxProduct {

	// 动态规划
	// 1.涉及子数组的暴力解法的for循环有两种遍历方式，一种是按照开头分类，一种是按照结尾分类
	// 2.可以先想暴力解法，再想优化（遍历顺序如果错了就不容易想到优化）。或者直接想到动态规划。
	public static double maxProduct(double[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		double res = arr[0];
		double max = arr[0];
		double min = arr[0];

		double maxTemp;
		double minTemp;

		for (int i = 1; i < arr.length; i++) {
			maxTemp = max * arr[i];
			minTemp = min * arr[i];
			max = Math.max(Math.max(maxTemp, minTemp), arr[i]);
			min = Math.min(Math.min(maxTemp, minTemp), arr[i]);
			res = Math.max(res, max);
		}
		return res;
	}

	public static void main(String[] args) {
		double[] arr = { -2.5, 4, 0, 3, 0.5, 8, -1 };
		System.out.println(maxProduct(arr));
	}

}
