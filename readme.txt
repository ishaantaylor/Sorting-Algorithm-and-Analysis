
Reporting2 program (.java + .class):
Simply type "run Reporting2 <input_file>" and it will create 3 labeled files with the sorted array with respective routines.

Reporting1 program (.java + .class):
Type "run Reporting1" to see the process of the testing and variance. This will output four files "sorted.txt, r_sorted.txt, random.txt, variance.txt". These display the data in a text file which I then exported to "data.xlsx". The report for this project is written below.

MergeSort:   class implements recursive merge sort
Sorting:     class serves as pseudo interface for different sorts
Heap:        class implements heap sort
QuickSort:   class implemenets quick sort 
IterativeMS: class attempts to implement iterative merge sort without back copying, but couldn't complete it. What I tried is outlined in the report.

data.xlsx:   spreadsheet of data
data.txt:    input of data

Output files (examples):
	variance.txt
	sorted.txt
	random.txt
	r_sorted.txt
	ist2QS.txt
	ist2MS.txt
	ist2HS.txt

Report:
	As can be clearly seen from the graphs, my heap sort is the quickest algorithm out of the three, quick sort closely following it, and then my merge sort takes very long. What is not so obvious is in the lower sample sizes, merge sort for all arrays take the shortest amount of time. However, again, it rapidly increases time taken.

	It can be seen that:
		Heap Sort has average time of O(n*log(n)) and worst case of O(n*log(n)).
		Quick Sort has average time of O(n*log(n)) and worst case of O(n^2).
		Merge Sort has average time and worst case of O(n*log(n)) but requires constant space.

	
