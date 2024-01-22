/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 *
 * This class contains methods for sorting elements in arrays using various sorting algorithms.
 *
 * @Owner/Student Name: Hamza El Sousi
 * Student Number: 040-982-818
 * Section #: CST8130 - 302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD.
 */
import java.util.Arrays;

/**
 * * This class contains methods for sorting elements in an array using various
 * sorting algorithms, including Bubble Sort, Insertion Sort, Selection Sort,
 * Merge Sort, and Quick Sort.
 *
 * @param <T> The type of elements in the array, which must implement the
 *            Comparable interface.
 */
public class SortingAlgorithms<T extends Comparable<T>> {
	/**
     * The array to be sorted.
     */
	T[] randomArr;

	/**
	 * Constructor to initialize the randomArr array.
	 *
	 * @param size The size of the array to be created.
	 */
	@SuppressWarnings("unchecked")
	public SortingAlgorithms(int size) {
		randomArr = (T[]) new Comparable[size];
	}

	/**
	 * Generates random elements and populates the randomArr array.
	 */
	public void genRandomElements() {
		for (int i = 0; i < randomArr.length; i++) {
			randomArr[i] = (T) generateRandomElement();
		}
	}

	private Integer generateRandomElement() {
		return (int) (Math.random() * 880) + 120;
	}

	/**
	 * Sorts the array using the Bubble Sort algorithm.
	 */
	public void bubbleSort() {
		int n = randomArr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (randomArr[j].compareTo(randomArr[j + 1]) > 0) {
					swap(j, j + 1);
				}
			}
		}
	}

	/**
	 * Sorts the array using the Insertion Sort algorithm.
	 */
	public void insertionSort() {
		int n = randomArr.length;
		for (int i = 1; i < n; i++) {
			T key = randomArr[i];
			int j = i - 1;
			while (j >= 0 && randomArr[j].compareTo(key) > 0) {
				randomArr[j + 1] = randomArr[j];
				j--;
			}
			randomArr[j + 1] = key;
		}
	}

	/**
	 * Sorts the array using the Selection Sort algorithm.
	 */
	public void selectionSort() {
		int n = randomArr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (randomArr[j].compareTo(randomArr[minIndex]) < 0) {
					minIndex = j;
				}
			}
			swap(i, minIndex);
		}
	}

	/**
	 * Sorts the array using the Merge Sort algorithm.
	 */
	public void mergeSort() {
		mergeSortHelper(0, randomArr.length - 1);
	}

	// helper method
	private void mergeSortHelper(int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSortHelper(left, mid);
			mergeSortHelper(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private void merge(int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		T[] leftArray = Arrays.copyOfRange(randomArr, left, left + n1);
		T[] rightArray = Arrays.copyOfRange(randomArr, mid + 1, mid + 1 + n2);

		int i = 0, j = 0, k = left;

		while (i < n1 && j < n2) {
			if (leftArray[i].compareTo(rightArray[j]) <= 0) {
				randomArr[k] = leftArray[i];
				i++;
			} else {
				randomArr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			randomArr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			randomArr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	/**
	 * Sorts the array using the Quick Sort algorithm.
	 */
	public void quickSort() {
		quickSortHelper(0, randomArr.length - 1);
	}

	// helper method
	private void quickSortHelper(int low, int high) {
		if (low < high) {
			int pivotIndex = partition(low, high);
			quickSortHelper(low, pivotIndex - 1);
			quickSortHelper(pivotIndex + 1, high);
		}
	}

	/**
	 * Partitions the array for the Quick Sort algorithm.
	 *
	 * @param low  The index of the lower bound of the partition.
	 * @param high The index of the upper bound of the partition.
	 * @return The index of the pivot element after partitioning.
	 */
	private int partition(int low, int high) {
		T pivot = randomArr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (randomArr[j].compareTo(pivot) < 0) {
				i++;
				swap(i, j);
			}
		}

		swap(i + 1, high);
		return i + 1;
	}

	/**
	 * Swaps elements at indices i and j in the array
	 */
	private void swap(int i, int j) {
		T temp = randomArr[i];
		randomArr[i] = randomArr[j];
		randomArr[j] = temp;
	}
}