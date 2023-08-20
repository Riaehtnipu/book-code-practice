package chapter_8_arrayandmatrix;

// https://www.nowcoder.com/practice/d311bcce968d4d849d998a799bf7492a?tpId=101&tqId=33104&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D101%26type%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E6%95%B0%E7%BB%84%E7%9A%84
// https://www.nowcoder.com/practice/0d65e18ca5784ae68577d9591df23033?tpId=101&tqId=33105&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D101%26type%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E6%95%B0%E7%BB%84%E7%9A%84
public class Problem_23_PartitionArray {

	public static void leftUnique(int[] arr) {
		int u = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[u]) {
				// 这里不用回溯i指针！！！
				swap(arr, i, ++u);
			}
		}
	}

	public static void sort(int[] arr) {
		int left = -1;
		int right = arr.length;
		int index = 0;
		while (index < right) {
			if (arr[index] == 0) {
				swap(arr, index++, ++left);
			} else if (arr[index] == 2) {
				swap(arr, index, --right);
			} else {
				index++;
			}
		}
	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9 };
		printArray(arr1);
		leftUnique(arr1);
		printArray(arr1);

		System.out.println();

		int[] arr2 = { 2, 1, 2, 0, 1, 1, 2, 2, 0 };
		printArray(arr2);
		sort(arr2);
		printArray(arr2);

	}

}
