import java.util.*;

public class NonRecursive {
    public static int maximumProduct(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;


        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;


        for (int num : nums) {

            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }


            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
        }


        int product1 = max1 * max2 * max3;
        int product2 = min1 * min2 * max1;


        return Math.max(product1, product2);
    }

    public static void main(String[] args) {
        System.out.println("\n ----Maximum Product of 3 Numbers Non-Recursive---- \n");

        System.out.print("Enter the the number of Elements: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n < 3) {
            System.out.println("Need at least 3 elements.");
            System.out.print("Enter the the number of Elements: ");
            n = scan.nextInt();
        }
        System.out.println("Enter " + n + " integers: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println("The maximum product is: " + maximumProduct(nums));
    }
}
