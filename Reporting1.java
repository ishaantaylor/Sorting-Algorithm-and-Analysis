import java.util.*;
import java.io.*;
/** 
 * This class/functino generates all my arrays for sorting,
 * runs each of the sorting methods as many times as specified 
 *   in the assignment
 * (gives them the generated arrays as arguments)
 * records the execution times (of 3 sorting methods) and
 * prints out results in a form suitable for inclusion into
 *   your report 
 * and/or 
 * writes out the results into a file (if you need to post process results)
 * ^post process means graphs
 */
public class Reporting1 {
  
  /** 
   * Generates array of random elements of 'size' size 
   * 
   * @param size, size of array
   * @param range, upper bound of positive random numbers generated
   */
  public static int[] gra(int size, int range) {
    int[] arr = new int[0];
    if (size >= 0 && range >= 0) { 
      arr = new int[size];
      Random r = new Random();
      for (int i = 0; i < size; i++)
        arr[i] = r.nextInt(range);
    } return arr;
  }
  
  /**
   * Computing the mean
   */
  public static double meanV(int[] arr) {
    double sum = 0;
    for (int i = 0; i < arr.length; i++)
      sum += arr[i];
    return sum/arr.length;
  }
  
  /**
   * Variance
   */
  public static double variance(int[] arr) {
    double variance = 0;
    double m = meanV(arr);
    for(int i = 0; i < arr.length; i++) 
      variance += ((arr[i] - m) * (arr[i] - m));
    return variance / (arr.length - 1);
  }
  
  /**
   * Generates sorted array of sequential elements.
   * Element value is 2n + 1 for n elements
   * 
   * @param size, size of array
   */
  public static int[] gsa(int size) {
    int[] arr = new int[size];
    for (int i = 0; i < arr.length; i++) 
      arr[i] = i + 1;
    return arr;
  }
  
  /**
   * Generates reverse sorted array.
   * 
   * @param size, size of array
   */
  public static int[] grsa(int size) {
    int[] arr = new int[size];
    int k = arr.length;
    for (int i = 0; i < arr.length; i++)
      arr[i] = k--;
    return arr;
  }

  /* 
   * Calculates the average of three runtimes
   */
  public static long average(long num1, long num2, long num3) {
    return (num1+num2+num3)/3;
  }

  /** probably not used 
  public static long average(long[] arr) {
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum/arr.length;
  } */
  
  /* print array of Long */
  public static void print(Long[] arr) {
    System.out.print("{");
    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + ", ");
    System.out.println("}");
  }

  public static void print(double[] arr) {
    System.out.print("{");
    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + ", ");
    System.out.println("}");
  }
  
  public static void main(String args[]) {
    /******************
      General Format...
      **
      Allocate arrays
      Print goal
      Sort
      Store Times
    */
    
    /**
     * The higher volume array times were computed separately from the main method
     * to speed up the process. However, the code to test them is written.
     */


    /************************************************************************
     * Sorted Arrays 
     */
    Long[] hsT = new Long[7];               // allocate arrays
    Long[] qsT = new Long[7];
    Long[] msT = new Long[7];

                                            // print goal
    System.out.println("Testing performance of different sorts with sorted arrays.");
    
    /* n = 100 ******************************/
    int[] arr = gsa(100);                         // allocate arrays ctd..
    System.out.println("n = 100");
    double[] v = new double[3];
    v[0] = variance(arr);

    
    hsT[0] = Sorting.heapSort(arr);                  // sorting
    qsT[0] = Sorting.quickSort(arr);
    msT[0] = Sorting.mergeSort(arr);
               // takes average of three runs
    
    /* n = 500 ******************************/
    System.out.println("n = 500");

    hsT[1] = Sorting.heapSort(gsa(500));
    qsT[1] = Sorting.quickSort(gsa(500));
    msT[1] = Sorting.mergeSort(gsa(500));
               // takes average of three runs

    /* n = 1000 *****************************/
    System.out.println("n = 1000");
    int[] h = gsa(1000);
    int[] q = gsa(1000);
    int[] m = gsa(1000);
    hsT[2] = Sorting.heapSort(h);
    qsT[2] = Sorting.quickSort(q);
    msT[2] = Sorting.mergeSort(m);
               // takes average of three runs
    
    /* n = 5000 *****************************/
    System.out.println("n = 5000");
    h = gsa(5000);
    q = gsa(5000);
    m = gsa(5000);
    hsT[3] = Sorting.heapSort(h);
    qsT[3] = Sorting.quickSort(q);
    msT[3] = Sorting.mergeSort(m);
               // takes average of three runs
        
    /* n = 10000 ****************************/
    System.out.println("n = 10000");
    h = gsa(10000);
    q = gsa(10000);
    m = gsa(10000);
    hsT[4] = Sorting.heapSort(h);
    qsT[4] = Sorting.quickSort(q);
    msT[4] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 50000 ****************************/
    System.out.println("n = 50000");
    h = gsa(50000);
    q = gsa(50000);
    m = gsa(50000);
    hsT[5] = Sorting.heapSort(h);
    qsT[5] = Sorting.quickSort(q);
    msT[5] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 100000 ***************************/
    System.out.println("n = 100000");
    h = gsa(100000);
    q = gsa(100000);
    m = gsa(100000);
    hsT[6] = Sorting.heapSort(h);
    qsT[6] = Sorting.quickSort(q);
    msT[6] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 500000 ***************************
    System.out.println("n = 500000");
    h = gsa(500000);
    q = gsa(500000);
    m = gsa(500000);
    hsT[7] = Sorting.heapSort(h);
    qsT[7] = Sorting.quickSort(q);
    msT[7] = Sorting.mergeSort(m);
               // takes average of three runs
    */

    /************************************************************************
     * Reverse Sorted Arrays 
     */
    Long[] hsT_r = new Long[7];
    Long[] qsT_r = new Long[7];
    Long[] msT_r = new Long[7];
    
    System.out.println("Testing performance of different sorts with reverse sorted arrays.");
    
    /* n = 100 ******************************/
    System.out.println("n = 100");
    
    h = grsa(100);
    q = grsa(100);
    m = grsa(100);
    hsT_r[0] = Sorting.heapSort(h);
    qsT_r[0] = Sorting.quickSort(q);
    msT_r[0] = Sorting.mergeSort(m);
    v[1] = variance(h);
               // takes average of three runs
    
    /* n = 500 ******************************/
    System.out.println("n = 500");
    h = grsa(500);
    q = grsa(500);
    m = grsa(500);
    hsT_r[1] = Sorting.heapSort(h);
    qsT_r[1] = Sorting.quickSort(q);
    msT_r[1] = Sorting.mergeSort(m);
               // takes average of three runs
    
    /* n = 1000 *****************************/
    System.out.println("n = 1000");
    h = grsa(1000);
    q = grsa(1000);
    m = grsa(1000);
    hsT_r[2] = Sorting.heapSort(h);
    qsT_r[2] = Sorting.quickSort(q);
    msT_r[2] = Sorting.mergeSort(m);
               // takes average of three runs
    
    /* n = 5000 *****************************/
    System.out.println("n = 5000");
    h = grsa(5000);
    q = grsa(5000);
    m = grsa(5000);
    hsT_r[3] = Sorting.heapSort(h);
    qsT_r[3] = Sorting.quickSort(q);
    msT_r[3] = Sorting.mergeSort(m);
               // takes average of three runs
    
    /* n = 10000 ****************************/
    System.out.println("n = 10000");
    h = grsa(10000);
    q = grsa(10000);
    m = grsa(10000);
    hsT_r[4] = Sorting.heapSort(h);
    qsT_r[4] = Sorting.quickSort(q);
    msT_r[4] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 50000 ****************************/
    System.out.println("n = 50000");
    h = grsa(50000);
    q = grsa(50000);
    m = grsa(50000);
    hsT_r[5] = Sorting.heapSort(h);
    qsT_r[5] = Sorting.quickSort(q);
    msT_r[5] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 100000 ***************************/
    System.out.println("n = 100000");
    h = grsa(100000);
    q = grsa(100000);
    m = grsa(100000);
    hsT_r[6] = Sorting.heapSort(h);
    qsT_r[6] = Sorting.quickSort(q);
    msT_r[6] = Sorting.mergeSort(m);
               // takes average of three runs
    /* n = 500000 ***************************
    System.out.println("n = 500000");
    h = grsa(500000);
    q = grsa(500000);
    m = grsa(500000);
    hsT_r[7] = Sorting.heapSort(h);
    qsT_r[7] = Sorting.quickSort(q);
    msT_r[7] = Sorting.mergeSort(m);
               // takes average of three runs
    */

    /************************************************************************
     * Randomly Generated Arrays 
     */
    Long[] hsT_ran = new Long[7];
    Long[] qsT_ran = new Long[7];
    Long[] msT_ran = new Long[7];
    
    System.out.println("Testing performance of different sorts with randomly generated arrays.");
    
    /* n = 100 ******************************/
    System.out.println("n = 100");
    h = gra(100, 1000);
    q = gra(100, 1000);
    m = gra(100, 1000);
    hsT_ran[0] = Sorting.heapSort(h);
    qsT_ran[0] = Sorting.quickSort(q);
    msT_ran[0] = Sorting.mergeSort(m);
    v[2] = variance(h);

               // takes average of three runs
    
    /* n = 500 ******************************/
    System.out.println("n = 500");
    h = gra(500, 1000);
    q = gra(500, 1000);
    m = gra(500, 1000);
    hsT_ran[1] = Sorting.heapSort(h);
    qsT_ran[1] = Sorting.quickSort(q);
    msT_ran[1] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 1000 *****************************/
    System.out.println("n = 1000");
    h = gra(1000, 1000);
    q = gra(1000, 1000);
    m = gra(1000, 1000);
    hsT_ran[2] = Sorting.heapSort(h);
    qsT_ran[2] = Sorting.quickSort(q);
    msT_ran[2] = Sorting.mergeSort(m);
               // takes average of three runs
    
    /* n = 5000 *****************************/
    System.out.println("n = 5000");
    h = gra(5000, 1000);
    q = gra(5000, 1000);
    m = gra(5000, 1000);
    hsT_ran[3] = Sorting.heapSort(h);
    qsT_ran[3] = Sorting.quickSort(q);
    msT_ran[3] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 10000 ****************************/
    System.out.println("n = 10000");
    h = gra(10000, 1000);
    q = gra(10000, 1000);
    m = gra(10000, 1000);
    hsT_ran[4] = Sorting.heapSort(h);
    qsT_ran[4] = Sorting.quickSort(q);
    msT_ran[4] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 50000 ****************************/
    System.out.println("n = 50000");
    h = gra(50000, 1000);
    q = gra(50000, 1000);
    m = gra(50000, 1000);
    hsT_ran[5] = Sorting.heapSort(h);
    qsT_ran[5] = Sorting.quickSort(q);
    msT_ran[5] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 100000 ***************************/
    System.out.println("n = 100000");
    h = gra(100000, 1000);
    q = gra(100000, 1000);
    m = gra(100000, 1000);
    hsT_ran[6] = Sorting.heapSort(h);
    qsT_ran[6] = Sorting.quickSort(q);
    msT_ran[6] = Sorting.mergeSort(m);
               // takes average of three runs

    /* n = 500000 ***************************
    System.out.println("n = 500000");
    h = gra(500000, 1000);
    q = gra(500000, 1000);
    m = gra(500000, 1000);
    hsT_ran[7] = Sorting.heapSort(h);
    qsT_ran[7] = Sorting.quickSort(q);
    msT_ran[7] = Sorting.mergeSort(m);
               // takes average of three runs
    */
    
    
    print(hsT);
    print(qsT);
    print(msT);
    print(hsT_r);
    print(qsT_r);
    print(msT_r);
    print(hsT_ran);
    print(qsT_ran);
    print(msT_ran);
    print(v);
    
    /******************************************************************8
    *   File Output
    ************************/
    try { 
      BufferedWriter writerS = new BufferedWriter(new FileWriter("sorted.txt"));
      BufferedWriter writerRS = new BufferedWriter(new FileWriter("r_sorted.txt"));
      BufferedWriter writerRAN = new BufferedWriter(new FileWriter("random.txt")); 
      BufferedWriter writerV = new BufferedWriter(new FileWriter("variance.txt")); 

      /* Sorted Array */
      writerS.write("{", 0, 1);
      for (Long l : hsT) 
        writerS.write(l + ", ", 0, (l + ", ").length());   
      writerS.write("} *******", 0, 8);

      /* Reverse Sorted Array */
      writerRS.write("{", 0, 1);
      for (Long l : hsT_r) 
        writerRS.write(l + ", ", 0, (l + ", ").length());   
      writerRS.write("} *******", 0, 8);

      /* Randomly Sorted Array */
      writerRAN.write("{", 0, 1);
      for (Long l : hsT_ran) 
        writerRAN.write(l + ", ", 0, (l + ", ").length());   
      writerRAN.write("} *******", 0, 8);
      writerS.close();
      writerRS.close();
      writerRAN.close();

      String[] s = { "Sorted ", "Reverse sorted ", "Randomly assorted " };
      String str = null;
      for (int y = 0; y < s.length; y++) {
        str = s[y] + "variance: " + v[y] + "\n";
        writerV.write(str, 0 , str.length());
      }
      writerV.close();
    } catch (IOException e) { 
      System.err.format("IOException: %s%n", e);
    }
  }
}