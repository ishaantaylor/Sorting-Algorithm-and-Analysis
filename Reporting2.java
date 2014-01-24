import java.io.*;
import java.util.*;

public class Reporting2 {
 /*
  We will be testing your work by typing 
  â€œjava reporting2 <input_file>â€?
  on the command line, 
  for example, â€œjava reporting2 inFileâ€?. Your program, for each of 
  the three runs of each of the three sorting methods, will read input_file into an array, 
  then 
  invoke the needed sorting method. 

  For one of the runs of each method (e.g., for the first run), your program will also write out the output file with the name that starts with your 
  case ID and append to it the abbreviation of the method name. 

  Thus, since my case ID is 
  mxr136, my program would produce three files: mxr136HS, mxr136QS, and mxr136MS. 
  (Just hard-code these names within your program as string literals.) Finally, your 
  program must print out the results in the form: â€œHS<caseID> time; QS<caseID> time; 
  MS<caseID> time;â€? where <caseID> is your case ID. For instance, my program might 
  â€œHSmxr136 3682; QSmxr136 3456; MSmxr136 4320â€?.
 */

 /** args[0] must be input file's string representation */
 public static void main(String[] args) {
   String file = args[0];                                  // input file name
   String line = null;
   LinkedList<Integer> ll = (LinkedList<Integer>) new LinkedList();
   try {
     BufferedReader reader   = new BufferedReader(new FileReader(file));
                                                           // create separate writers for separate intended files
     BufferedWriter writerHS = new BufferedWriter(new FileWriter("ist2HS.txt"));
     BufferedWriter writerQS = new BufferedWriter(new FileWriter("ist2QS.txt"));
     BufferedWriter writerMS = new BufferedWriter(new FileWriter("ist2MS.txt"));
     
     
     Integer num;
     while ((line = reader.readLine()) != null) {    // read line by line, efficiency
       num = Integer.parseInt(line);                 // read a character, parse the *integer*
       ll.add(num);                                  //  and add to linked list
     }
     Integer[] temp_arrHS = {};                      /* convert array list to arrays for each type of sort */
     temp_arrHS = ll.toArray((Integer[]) temp_arrHS);
     int[] arrHS = new int[temp_arrHS.length];
     int[] arrQS = new int[arrHS.length];
     int[] arrMS = new int[arrHS.length];
     for (int i = 0; i < arrHS.length; i++) {
       arrHS[i] = temp_arrHS[i].intValue();
       arrQS[i] = temp_arrHS[i].intValue();
       arrMS[i] = temp_arrHS[i].intValue();
     }
     

     /* HeapSort stuff */
     Heap h = new Heap(arrHS);                           // input array
     arrHS = h.myHeapSort();
     Long hsT = h.getTime();                             // get time for heap sort
     String s;
     for (int i = 0; i < arrHS.length; i++) {            // print array
       s = arrHS[i]+"";
       writerHS.write(s, 0, s.length());
       writerHS.write("\n");
     }
     s = ("Heap Sort <ist2>: " + hsT.toString());
     writerHS.write(s, 0, s.length());                   // print name and time
     writerHS.close();
     
     /* QuickSort stuff */
     QuickSort qs = new QuickSort();                     // create quick sort obj
     qs.quickSort(arrQS);                                // quicksort sorts in spot
     Long qsT = qs.getTime();
     for (int i = 0; i < arrQS.length; i++) {            // print array
       s = arrHS[i]+"";
       writerQS.write(s, 0, s.length());
       writerQS.write("\n");
     }
     s = ("Quick Sort <ist2>: " + qsT.toString());       // print name and time
     writerQS.write(s, 0, s.length());
     writerQS.close();
     
     /* MergeSort Stuff */
     MergeSort ms = new MergeSort(arrMS);
     ms.mergeSort(arrMS);
     Long msT = ms.getTime();
     for (int i = 0; i < arrMS.length; i++) {            // print array
       s = arrMS[i]+"";
       writerMS.write(s, 0, s.length());
       writerMS.write("\n");
     }
     s = ("Merge Sort <ist2>: " + msT.toString());       // print name and time
     writerMS.write(s, 0, s.length());
     writerMS.close();
   } catch (IOException e) {
     System.err.format("IOException: %s%n", e);
   }
 }
}