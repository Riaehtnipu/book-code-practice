package chapter_8_arrayandmatrix;

// https://www.nowcoder.com/practice/d1c8838fc9e54b89bc10b5b6d2b52157?tpId=101&tqId=33096&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E5%B1%80%E9%83%A8
public class Problem_18_FindOneLessValueIndex {

	// 二分
	public static int getLessIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		int mid;
		while (left < right) {
			mid = left + ((right - left) >>> 1);

			// mid能保证不越界
			if (mid - 1 >= 0 && arr[mid] > arr[mid - 1]) {
				// 结束条件为left==right，可以保证退出
				right = mid;
			} else if (mid + 1 <= arr.length - 1 && arr[mid] > arr[mid + 1]) {
				left = mid;
			} else {
				return mid;
			}
		}
		return left;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
		int[] arr = { 2,1,3 };
		printArray(arr);
		int index = getLessIndex(arr);
		System.out.println("index: " + index + ", value: " + arr[index]);

	}

}
