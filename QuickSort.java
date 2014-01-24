import java.util.*;

/** Quicksort implementation for int arrays */
public class QuickSort {
  /** Fields */
  int[] origArr; // original array for multiple time trials
  int[] array;   // 
  Long  time;    // 
  
  /** Constructors*/ 
  public QuickSort(int[] array) {
    this.array = array;
  }

  public QuickSort() {}

  
  /** Methods */
  public void quickSort(int[] arr) {
    origArr = arr;
    myQuickSort(arr, 0, arr.length-1);        // call quick sort
  }
  
  /** Time reporting method */
  public Long getTime() {
    Long t1 = time;
    Long t2; 
    Long t3;
    quickSort(origArr);
    t2 = time;
    quickSort(origArr);
    t3 = time;
    return Reporting1.average(t1, t2, t3);    // avg of three longs
  }

  /*
   * @param arr    array to be sorted
   * @param beg    initial index of sorting
   * @param end    final index of sorting
   */
  public void myQuickSort(int[] arr, int beg, int end) {
    Long startTime = System.nanoTime();
    if (beg < end) {
      int piv = beg + (end - beg)/2;
      piv = partition(arr, beg, end, piv);   // new pivot
      myQuickSort(arr, beg, piv - 1);        // sorts right sub array
      myQuickSort(arr, piv + 1, end);        // sorts left sub array
    } 
    time = System.nanoTime() - startTime;
    array = arr;
  }
  
  /*
   * Rearranges the sub-array (A[beg...end] in place)
   */
  public int partition(int[] arr, int beg, int end, int piv) {
    int pivotV = arr[piv];              // initial pivot selection from previous method
    int elem = arr[end];
    arr[end] = arr[piv];
    arr[piv] = elem;
    int i = beg;                        // i cursor behind beginning 
    for (int j = beg; j < end; j++) {   // j cursor right in front of i cursor
      if (arr[j] <= pivotV) {           // if jth index is bigger
        elem = arr[i];                  // swap ith and jth element
        arr[i] = arr[j]; 
        arr[j] = elem;
        i++;                            // increment i
      }
    }
    elem = arr[i];
    arr[i] = arr[end];
    arr[end] = elem;
    return i;
  }
  
  /** Main method for user testing */
  public static void main (String[] args) {
    Integer numel = Integer.parseInt(args[0]);
    int[] arr = new int[numel];
    Random r = new Random();
    for (int i = 0; i < arr.length; i++)
      arr[i] = r.nextInt(10000);
    System.out.print("  Original Array: ");
    Sorting.print(arr);
    QuickSort qs = new QuickSort(arr);
    qs.quickSort(arr);
    System.out.print("  Sorted Array: ");
    Sorting.print(qs.array);
  }
}