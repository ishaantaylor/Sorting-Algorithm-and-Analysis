/**  Iterative merge sort

This class attempts to implement iterative merge sort without back copying 
*/
public class IterativeMS {
  
  /** This is the initial method */
  public void mergeSort(int[] arr) {
    if (arr.length <= 2)
      return;
    else if (arr.length == 2) {
      if (arr[0] > arr[1]) {
        int elem = arr[0];
        arr[0] = arr[1];
        arr[1] = elem;   
      } 
      return;
    }
    sort(arr, new int[arr.length], 0, arr.length/2, arr.length-1);
  }
  
  /** This method merges each subarray */
  public void merge(int[] arrA, int[] arrB, int ileft, int iright, int iend) {
    int i0 = ileft;
    int i1 = iright;
    int j;

    for (j = ileft; j < iend; j++) {
      if (i0 < iright && (i1 >= iend || arrA[i0] <= arrA[i1])) 
        arrB[j] = arrA[i0++];
      else
        arrB[j] = arrA[i1++];
    }
  }
  
  /** changes array */
  private void swapRoles(int[] arr, int[] copy) {
    for (int i = 0; i < arr.length; i++) 
      arr[i] = copy[i];
  }
  
  /** minimum of two ints */
  private int min(int i, int j) {
    if (i < j) 
      return i;
    else
      return j;
  }
  
  /** prints array */
  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println("}");
  }
  
  /** calls merge for each n^2 */
  public void sort(int[] arr, int[] copy, int ileft, int iright, int iend) {
    int w;
                                  // for current width of array
    for (w = 1; w <= arr.length; w *= 2) {
      for (int i = 0; i < arr.length; i += 2*w) 
        merge(arr, copy, i, min(arr.length,i + w), min(arr.length,i + 2*w));
//      int[] temp = arr;           // to avoid back copying, switch array of each iteration 
//      arr = copy;                 // HOW DO I DO THIS WITH PBR
//      copy = temp;
      swapRoles(arr,copy);
    }
  } 
  
  /** This main method tests the various cases */
  public static void main(String[] args) {
    IterativeMS ims = new IterativeMS();
    int[] arr = Reporting1.grsa(7);
    ims.mergeSort(arr);
    print(arr);
    
    arr = Reporting1.grsa(8);
    ims.mergeSort(arr);
    print(arr);
    
    arr = Reporting1.grsa(9);
    ims.mergeSort(arr);
    print(arr);
    
    arr = Reporting1.gra(7, 10);
    ims.mergeSort(arr);
    print(arr);
    
    arr = Reporting1.gra(8, 10);
    ims.mergeSort(arr);
    print(arr);
    
    arr = Reporting1.gra(9, 10);
    ims.mergeSort(arr);
    print(arr);
    
    arr = Reporting1.grsa(2);
    ims.mergeSort(arr);
    print(arr);
    
    arr = Reporting1.grsa(32);
    ims.mergeSort(arr);
    print(arr);
    
  }
}

