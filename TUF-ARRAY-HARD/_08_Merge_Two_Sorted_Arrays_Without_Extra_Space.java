import java.util.*;

public class _08_Merge_Two_Sorted_Arrays_Without_Extra_Space {

	public static void bruteForce(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] temp = new int[n + m];
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < n && j < m) {
			if (arr1[i] <= arr2[j]) {
				temp[k++] = arr1[i++];
			} else {
				temp[k++] = arr2[j++];
			}
		}

		while (i < n) {
			temp[k++] = arr1[i++];
		}

		while (j < m) {
			temp[k++] = arr2[j++];
		}

		for (i = 0; i < n; i++) {
			arr1[i] = temp[i];
		}

		for (j = 0; j < m; j++) {
			arr2[j] = temp[n + j];
		}
	}

	public static void optimal(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int gap = (n + m + 1) / 2;

		while (gap > 0) {
			int left = 0;
			int right = left + gap;

			while (right < n + m) {
				int leftValue = getValue(arr1, arr2, n, left);
				int rightValue = getValue(arr1, arr2, n, right);

				if (leftValue > rightValue) {
					setValue(arr1, arr2, n, left, rightValue);
					setValue(arr1, arr2, n, right, leftValue);
				}

				left++;
				right++;
			}

			if (gap == 1) {
				break;
			}

			gap = (gap + 1) / 2;
		}
	}

	private static int getValue(int[] arr1, int[] arr2, int n, int index) {
		if (index < n) {
			return arr1[index];
		}
		return arr2[index - n];
	}

	private static void setValue(int[] arr1, int[] arr2, int n, int index, int value) {
		if (index < n) {
			arr1[index] = value;
		} else {
			arr2[index - n] = value;
		}
	}

	private static String arrayToString(int[] nums) {
		return Arrays.toString(nums);
	}

	public static void main(String[] args) {
		int[] arr1 = {1, 4, 7, 8, 10};
		int[] arr2 = {2, 3, 9};
		int[] arr3 = {1, 4, 7, 8, 10};
		int[] arr4 = {2, 3, 9};

		bruteForce(arr1, arr2);
		optimal(arr3, arr4);

		System.out.println(arrayToString(arr1));
		System.out.println(arrayToString(arr2));
		System.out.println(arrayToString(arr3));
		System.out.println(arrayToString(arr4));
	}
}
