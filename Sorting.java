/** 
 * Main class that refers to the various sorting routines.
 */
public class Sorting {
  /** No member variables */
  
  public static Long heapSort(int[] arr) {
    Heap heap = new Heap(arr);
    heap.heapSort(arr);                // sort 
    return heap.getTime();             // report times
  }
  
  public static Long quickSort(int[] arr) {  // (Include your pivot-selection technique into this method.)  
    /*
    public int partition(int[] arr, int beg, int end) {
    int pivot = arr[(end+beg/2)];              // initial pivot selection from previous method
    int i = beg - 1;                   // i cursor behind beginning 
    for (int j = beg; j < end; j++) {  // j cursor right in front of i cursor
      if (arr[j] <= pivot) {           // if jth index is bigger
        i += 1;                        // increment i
        int elem = arr[i];             // swap ith and jth element
        arr[i] = arr[j]; 
        arr[j] = elem;
      }
    }
    int elem = arr[i+1];               // after looping, swap 
    arr[i+1] = arr[end];
    arr[end] = elem;
    return (i+1);
  } */
    QuickSort q = new QuickSort(arr);
    q.quickSort(arr);                  // sort 
    return q.getTime();                // report time
  }   
  
  public static Long mergeSort(int[] arr) { 
    MergeSort m = new MergeSort(arr);
    m.mergeSort(arr);                  // sort 
    return m.getTime();                // report time
  }

  /* print array of ints */
  public static void print(int[] arr) {
    System.out.print("{");
    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + ", ");
    System.out.println("}");
  }
  
}