/** This class implements merge sort recursively */
public class MergeSort {
    /** Fields */
    int[] array;
    int[] origArr;
    Long  time;

    /** No need for constructors */
    public MergeSort(int[] arr) {
      this.array = arr;
    }
        
    /** Methods */
    /**
     * Routine to mergesort two respectively sorted arrays.
     * 
     * @param a;    original array
     * @param copy; auxilliary array, but doesn't continuously copy back and forth between arrays
     * @param lo;   low index
     * @param mid;  middle index
     * @param hi;   high index
     */
    public void merge(int[] a, int[] copy, int lo, int mid, int hi) {
      for (int g = 0; g < a.length; g++)
        copy[g] = a[g];
      int i = lo;                             
      int j = mid + 1;
      for (int k = lo; k <= hi; k++) {          // merge back to a[]
        if (i > mid)                            // if lo > mid
          a[k] = copy[j++];                     // a[k] is the aux array[mid + 1]
        else if (j > hi)                        // if hi > mid
          a[k] = copy[i++];
        else if (copy[j] < copy[i])             // sort two arrays to one
          a[k] = copy[j++];
        else                           
          a[k] = copy[i++];
      }
    }

    // mergesort a[lo..hi] using copied array copy[lo..hi]
    private void sort(int[] a, int[] copy, int lo, int hi) {
        if (hi <= lo) 
            return;                                 // if indices don't make sense, return empty array
        int mid = lo + (hi - lo) / 2;
        sort(a, copy, lo, mid);                     // recurse for left
        sort(a, copy, mid + 1, hi);                 // recurse for right
        merge(a, copy, lo, mid, hi);                // merge the broken pieces, avoid back copyin
    }
          
    
    // sort method
    public Long sort(int[] a) {
        int[] copy = new int[a.length];             // aux array
        Long startTime = System.nanoTime();         
        sort(a, copy, 0, a.length-1);               // call sort method for entire array
        return time = System.nanoTime() - startTime;         
    }
     
    /** Time reporting method */
    public Long getTime() {
      Long t1 = time;
      Long t2 = sort(origArr);;
      Long t3 = sort(origArr);
      return Reporting1.average(t1, t2, t3);        // report averaeg of three trials
    }
    
    // wrapper method
    public void mergeSort(int[] arr) {
      origArr = arr;
      sort(arr);
    }

    /** Main method tests (for user use only) */
    public static void main(String[] args) {
      Integer numel = Integer.parseInt(args[0]);
      int[] arr = Reporting1.gra(numel,1000);
      System.out.print("  Original Array: ");
      Sorting.print(arr);
      MergeSort ms = new MergeSort(arr);
      ms.mergeSort(arr);
      System.out.print("  Sorted Array: ");
      Sorting.print(ms.array);
    }
}

