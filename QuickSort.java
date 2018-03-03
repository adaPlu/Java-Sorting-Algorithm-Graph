
public class QuickSort {
	
	public static void quickSort(int[] list) {
	    quickSort(list, 0, list.length - 1);
	  }

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}

	  /** A test method */
	  public static void main(String[] args) {
	    int[] list = {45,11,50,59,60,2,4,7,10};
	    quickSort(list);
	    for (int i = 0; i < list.length; i++)
	      System.out.print(list[i] + " ");
	  }

}