package chapter_7_bitoperation;

// https://www.nowcoder.com/practice/05b5d4f3a2a944fd9f33c47d13fad271?tpId=101&tqId=33213&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D101&difficulty=undefined&judgeStatus=undefined&tags=&title=%E5%A4%9A%E5%B0%91%E4%B8%AA
public class Problem_04_NumberOf1 {

    public static int count1(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>>= 1;
        }
        return res;
    }

    public static int count2(int n) {
        int res = 0;
        while (n != 0) {
            // 去掉最右边的1
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static int count3(int n) {
        int res = 0;
        while (n != 0) {
            // 去掉最右边的1
            n = n - (n & (~n + 1));
            res++;
        }
        return res;
    }

    public static int count4(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >>> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >>> 8) & 0x00FF00FF);
        n = (n & 0x0000FFFF) + ((n >>> 16) & 0x0000FFFF);
        return n;
    }

    public static void printNumBit(int n) {
        for (int i = 31; i != -1; i--) {
            if ((n & (1 << i)) != 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num = -1;
        System.out.println(count1(num));
        System.out.println(count2(num));
        System.out.println(count3(num));
        System.out.println(count4(num));
        printNumBit(0x55555555);
        printNumBit(0x33333333);
        printNumBit(0x0f0f0f0f);
        printNumBit(0x00ff00ff);
        printNumBit(0x0000ffff);
    }

}
