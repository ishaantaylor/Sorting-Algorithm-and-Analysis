/* Heap for int[] */
public class Heap {
  int[] array;    // member array
  int[] origArr;  // original array for multiple time trials
  int   nel;      // number of elements filling array
  Long  time;     // time to sort
  
  public Heap(int[] array) {
    this.array = array;
  }
  
  // initially, build heap
  public void buildHeap(int[] oldArray) {
    origArr = oldArray;
    array = new int[oldArray.length];       // create array 
    for (int i = 0; i < oldArray.length; i++) {
      array[i] = oldArray[i];               // copy array, sift up
      siftUp(i);
    }
    nel = array.length;                     // set nel
  }
  
  // sift down index of heap
  private void siftDown(int index) {
    int left = 2*index + 1;                 // set value of child
    int right = 2*index + 2;
    if (right >= nel)                       // if child1or2 index is OOB (out of bounds)
      right = index;                        //  makes values index so l.35 returns false
    if (left >= nel)                        //  and 0 here serves as safety net
      left = 0;
    if (left == 0 && right == index)        // if left & right aren't valid indices
      return;                               // for recursive completeness
                                            // if any child is greater than parent
    if ((array[index] < array[left]) || (array[index] < array[right])) {
      // determine which child is greater, sift that way
      if ((array[left] - array[index]) > (array[right] - array[index])) {
        int element = array[index];       // since array is of ints
        array[index] = array[left];       // swap elements left
        array[left] = element;
        siftDown(left);                   // if move was made recurse, else its done.
      } else if ((array[left] - array[index]) <= (array[right] - array[index])){
        int element = array[index];       // since array is of ints
        array[index] = array[right];      // swap elements right
        array[right] = element;
        siftDown(right);                  // if move was made recurse, else its done.
      }
    }
  }                          
  
  // sift up in heap 
  private void siftUp(int index) {
    // if index is bigger than parent, then swap
    int parent = (index -1) / 2;       // set value of parent
    if (parent < 0)                    // if parent is negative, 0
      return;                          // for recursive completeness 
    if (array[index] > array[parent]) {  
      int element = array[index];      // since array is of ints
      array[index] = array[parent];    // swap elements
      array[parent] = element;
      siftUp(parent);                  // if move was made, recurse. else its done.
    }
  }
  
  // remove max element in heap
  private int remax(int end) {
    nel = end;
    int maxKey = array[0];               // save max element
    array[0] = array[nel];               // put last in first/ replace max   
    siftDown(0);                         // sift down replaced max element
    return maxKey;                       // return the max key
  }
 
  // wrapper method
  public int[] heapSort(int[] arr) {              
    return myHeapSort();                          // calls myHeapSort
  }
  
  // wrapper method
  public int[] myHeapSort() {
    Long startTime = System.nanoTime();           // start time
    buildHeap(array);                             // build the heap
    int[] newA = new int[array.length];           // allocate new array
    for (int i = array.length-1; i >= 0; i--) {   // copy reverse array (max elements)
      newA[i] = remax(i);                         // remax returns max into newA at i
    }
    time = System.nanoTime() - startTime;
    return array = newA;
  }

  /** Time reporting method */
  public Long getTime() {
    Long t1 = time;               // average of three times
    Long t2; 
    Long t3;
    heapSort(origArr);            // for three different trials
    t2 = time;
    heapSort(origArr);
    t3 = time;
    return Reporting1.average(t1, t2, t3);
  }
  
  /** This main method is mainly for user testing. */
  public static void main (String[] args) {
    int[] arr = new int[10];
    arr[0] = 10;
    arr[1] = 141;
    arr[2] = 22;
    arr[3] = 3125;
    arr[4] = 4;
    arr[5] = 564;
    arr[6] = 635;
    arr[7] = 79;
    arr[8] = 248;
    arr[9] = 92;
    Heap heap = new Heap(arr);
    System.out.print("      Original random array: ");
    Sorting.print(arr);
    
    int[] ans = heap.myHeapSort();
    System.out.print("          Test random array: ");
    Sorting.print(ans);
    
    Heap heapans = new Heap(ans);
    int[] test1 = heapans.myHeapSort();
    System.out.print("        Test a sorted array: ");
    Sorting.print(test1);
    
    int[] test2 = new int[ans.length];
    int j = 0;
    for (int i = ans.length-1; i >= 0; i--)
      test2[j++] = ans[i];
    Heap heap2 = new Heap(test2);
    test2 = heap2.myHeapSort();
    System.out.print("Test a reverse-sorted array: ");
    Sorting.print(test2);
    
    int[] arr1 = new int[1];
    arr1[0] = 10;
    Heap heap1 = new Heap(arr1);
    System.out.print("  Test single element array: ");
    int[] single = heap1.myHeapSort();
    Sorting.print(single);
    
    int[] arr2 = new int[0];
    Heap heap3 = new Heap(arr2);
    System.out.print("   Test empty element array: ");
    int[] empty = heap3.myHeapSort();
    Sorting.print(empty);
  }
}


