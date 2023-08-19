package chapter_7_bitoperation;

// https://www.nowcoder.com/practice/d0ef3e33e63a49dd99c90aeef306b0fc?tpId=101&tqId=33214&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E5%A5%87%E6%95%B0
public class Problem_05_EvenTimesOddTimes {

    public static void printOddTimesNum1(int[] arr) {
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        System.out.println(res);
    }

    public static void printOddTimesNum2(int[] arr) {
        int temp = 0;
        for (int num : arr) {
            temp ^= num;
        }

        int res = 0;
        int rightOne = temp & (~temp + 1);
        for (int num : arr) {
            if ((num & rightOne) == 0) {
                continue;
            }
            res ^= num;
        }
        System.out.println(res + " " + (temp ^ res));
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        printOddTimesNum2(arr2);

    }

}
