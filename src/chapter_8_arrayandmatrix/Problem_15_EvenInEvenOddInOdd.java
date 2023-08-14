package chapter_8_arrayandmatrix;

// https://www.nowcoder.com/practice/335823db14b945ab95241a74cfcf1ae7?tpId=101&tqId=33092&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E5%A5%87%E6%95%B0
public class Problem_15_EvenInEvenOddInOdd {

	public static void modify(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		int even = 0;
		int odd = 1;
		int index = arr.length - 1;
		while (even <= index && odd <= index) {
			if ((arr[index] & 1) == 0) {
				swap(arr, even, index);
				even += 2;
			} else {
				swap(arr, odd, index);
				odd += 2;
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, 3, 2, 4, 6 };
		printArray(arr);
		modify(arr);
		printArray(arr);
	}

}
