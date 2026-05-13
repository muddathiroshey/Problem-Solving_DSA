import java.util.*;
public class Recursive {
    public static int maximumProduct(int[] nums) {
        int n = nums.length;
        heapSort(nums);

        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int product2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(product1, product2);
    }

    private static void heapSort(int[] nums) {
        int n = nums.length;


        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }


        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    private static void heapify(int[] nums, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != rootIndex) {
            swap(nums, rootIndex, largest);
            heapify(nums, heapSize, largest);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("\n ----Maximum Product of 3 Numbers Recursive---- \n");

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
