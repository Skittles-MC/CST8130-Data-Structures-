import java.util.Random;
import java.util.Arrays;

public class Numbers {
	private int[] ints = null;
	private int size;
	// default constructor
	// initial constructor using an int parameter to set size of the array
	Numbers() {
		setSize(0);
		this.ints = new int[getSize()];
	}
	
	Numbers(int num) {
		setSize(num);
		ints = new int[getSize()];
	}
	/*
	 * method generateNumbers – which will use the Random class to fill the
	 * array with random numbers between 1 and 50.
	 */
	public void generateNumbers() {
		
		Random r = new Random();
		for (int i = 0; i < getSize(); i++) {
			ints[i] = r.nextInt(50) + 1;
		}
	}
	/*
	 * method count – will return an int which is a count of the number of
	 * occurrances of a parameter int contained in the array
	 */
	public int count(int num) {
		int counter = 0;
		for (int i = 0; i < getSize(); i++) {
			if (num == ints[i]) {
				counter++;
			}
		}
		return counter;
	}
	public String toString() {
		return Arrays.toString(ints);
	}

	// method binSearch – to perform binary search
	public int binSarch() {
		 // change search after
		//Arrays.sort(ints);
		recQuickSort( getSize(), getSize());
		int first, last, middle;
		int newSearch = Lab4.search;
		System.out.println(toString());
		first = 0;
		last = ints.length - 1;
		middle = (first + last) / 2;

		while (first <= last) {
			if (ints[middle] == newSearch)
				return middle;
			else if (ints[middle] < newSearch)
				first = middle + 1;
			else
				last = middle - 1;
			middle = (first + last) / 2;
		} // end of while
		return -1;
	}
	public  int recursiveBinarySearch(int[] ints, int key) {
		int newSearch = Lab4.search;
		key = newSearch;
		return recBinarySearch(ints, 0, ints.length - 1, key);
	}
	private  int recBinarySearch(int[] ints, int first, int last, int target) {
		//Arrays.sort(ints);
		recQuickSort( first, last);
		int middle = (first + last) / 2;
		if (last < first) {
			return -1;
		}
		if (target == ints[middle]) {
			return middle;
		} else if (target < ints[middle]) {
			return recBinarySearch(ints, first, middle - 1, target);
		} else {
			return recBinarySearch(ints, middle + 1, last, target);
		}
	}
	//method recQuickSort
		private  void recQuickSort( int left, int right){
				int index = partition ( left, right);
				if (left<right -1)
					recQuickSort(left, index -1);
				if (index < right)
					recQuickSort(index, right);
			}
		public  int partition( int left, int right){
		   	  int i = left, j = right;
		      int tmp;
		      int pivot = ints[(left + right) / 2];
		      while (i <= j) {
		            while (ints[i] < pivot)
		                  i++;
		            while (ints[j] > pivot)
		                  j--;
		            if (i <= j) {
		                  tmp = ints[i];
		                  ints[i] = ints[j];
		                  ints[j] = tmp;
		                  i++;
		                  j--;
		            }
		      };
		return i;
	}
			
			

		
		
		
		
		
		
		
		
		
		
		
		
		
//testing area		
//		//first part doesnt work as intended fix later
//		// method binSearch – to perform binary search
//		public int binSarch() {
//			 // change search after
//			//Arrays.sort(ints);
//			recQuickSort(ints, size, size);
//			int first, last, middle;
//			int newSearch = Lab4.search;
//			System.out.println(toString());
//			first = 0;
//			last = ints.length - 1;
//			middle = (first + last) / 2;
//
//			while (first <= last) {
//				if (ints[middle] == newSearch)
//					return middle;
//				else if (ints[middle] < newSearch)
//					first = middle + 1;
//				else
//					last = middle - 1;
//				middle = (first + last) / 2;
//			} // end of while
//			return -1;
//		}
//		public static int recursiveBinarySearch(int[] ints, int key) {
//			int newSearch = Lab4.search;
//			key = newSearch;
//			return recBinarySearch(ints, 0, ints.length - 1, key);
//		}
//		private static int recBinarySearch(int[] ints, int first, int last, int target) {
//			//Arrays.sort(ints);
//			recQuickSort(ints, first, last);
//			int middle = (first + last) / 2;
//			if (last < first) {
//				return -1;
//			}
//			if (target == ints[middle]) {
//				return middle;
//			} else if (target < ints[middle]) {
//				return recBinarySearch(ints, first, middle - 1, target);
//			} else {
//				return recBinarySearch(ints, middle + 1, last, target);
//			}
//		}
		
		// method recBinarySearch – to perform recursive binary search
		// public int recBinarySearch(ints[] ,int first, int last){
		// Arrays.sort(ints);
		// int newSearch = Lab3.search;
		// int middle = (first + last)/2;
		// if (last < first){
		// return -1;
		// }
		// if (newSearch == ints[middle]){
		// return middle;
		// }
		// else if (newSearch <ints[middle]){
		// return recBinarySearch(, first, ,middle -1 , newSearch);
		// }
		// int first , last , middle;
		// int newSearch = Lab3.search;
		// System.out.println(toString());
		// first = 0;
		// last = ints.length -1;

		// if (first < last){
		// middle = (first + last)/2;
		// if (newSearch < ints[middle]){
		//
		// }
		// }

		// public int recBinarySearch(int key, int l, int r) {
		// int newSearch = Lab3.search;
		// key = newSearch;
		// if (r < l) {
		// return -1;
		// }
		// //int mid is middle, key
		// int mid = (l + r) / 2;
		// if (key == ints[mid]) {
		// return mid;
		// }
		// if (key < ints[mid]) {
		// return recBinarySearch(key, l, mid - 1);
		// } else {
		// return recBinarySearch(key, mid + 1, r);
		// }
		// Arrays.sort(ints);
		// System.out.println("Testttt1");
		// int newSearch = Lab3.search;
		// int lower = 0;
		// int upper = ints.length - 1;
		// System.out.println("poop");
		//
		// while (lower <= upper) {
		//
		// int mid = lower + (upper - lower) / 2;
		//
		// if(newSearch < ints[mid])
		//
		// upper = mid - 1;
		//
		// else if (newSearch > ints[mid])
		//
		// lower = mid + 1;
		//
		//
		// else
		//
		// System.out.println("pop");
		// break;
		// }
		//
		// // return -1; // Returns -1 if no match is found
		// System.out.println("No match1");
		// }
		//
		// int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
		//
		// public int binarySearch(int key, int l, int r) {
		// if (r < l) {
		// return -1;
		// }
		// int mid = (l + r) / 2;
		// if (key == array[mid]) {
		// return mid;
		// }
		// if (key < array[mid]) {
		// return binarySearch(key, l, mid - 1);
		// } else {
		// return binarySearch(key, mid + 1, r);
		// }
		//
		// }
		//
		// public static void main(String[] args) {
		// BinarySearchRecTest b = new BinarySearchRecTest();
		//
		// for (int i = 2; i < 32; i += 2) {
		//
		// System.out.println("Search for element " + i);
		// System.out.println("This element is found at " + b.binarySearch(i, 0,
		// 14));
		// System.out.println("=======+============+=======+==============");
		// }
		// }
		// method recBinarySearch – to perform recursive binary search
		// public int recBinarySearch(ints[] ,int first, int last){
		// Arrays.sort(ints);
		// int newSearch = Lab3.search;
		// int middle = (first + last)/2;
		// if (last < first){
		// return -1;
		// }
		// if (newSearch == ints[middle]){
		// return middle;
		// }
		// else if (newSearch <ints[middle]){
		// return recBinarySearch(, first, ,middle -1 , newSearch);
		// }
		// int first , last , middle;
		// int newSearch = Lab3.search;
		// System.out.println(toString());
		// first = 0;
		// last = ints.length -1;

		// if (first < last){
		// middle = (first + last)/2;
		// if (newSearch < ints[middle]){
		//
		// }
		// }

		// public int recBinarySearch(int key, int l, int r) {
		// int newSearch = Lab3.search;
		// key = newSearch;
		// if (r < l) {
		// return -1;
		// }
		// //int mid is middle, key
		// int mid = (l + r) / 2;
		// if (key == ints[mid]) {
		// return mid;
		// }
		// if (key < ints[mid]) {
		// return recBinarySearch(key, l, mid - 1);
		// } else {
		// return recBinarySearch(key, mid + 1, r);
		// }
		// Arrays.sort(ints);
		// System.out.println("Testttt1");
		// int newSearch = Lab3.search;
		// int lower = 0;
		// int upper = ints.length - 1;
		// System.out.println("poop");
		//
		// while (lower <= upper) {
		//
		// int mid = lower + (upper - lower) / 2;
		//
		// if(newSearch < ints[mid])
		//
		// upper = mid - 1;
		//
		// else if (newSearch > ints[mid])
		//
		// lower = mid + 1;
		//
		//
		// else
		//
		// System.out.println("pop");
		// break;
		// }
		//
		// // return -1; // Returns -1 if no match is found
		// System.out.println("No match1");
		// }
		//
		// int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
		//
		// public int binarySearch(int key, int l, int r) {
		// if (r < l) {
		// return -1;
		// }
		// int mid = (l + r) / 2;
		// if (key == array[mid]) {
		// return mid;
		// }
		// if (key < array[mid]) {
		// return binarySearch(key, l, mid - 1);
		// } else {
		// return binarySearch(key, mid + 1, r);
		// }
		//
		// }
		//
		// public static void main(String[] args) {
		// BinarySearchRecTest b = new BinarySearchRecTest();
		//
		// for (int i = 2; i < 32; i += 2) {
		//
		// System.out.println("Search for element " + i);
		// System.out.println("This element is found at " + b.binarySearch(i, 0,
		// 14));
		// System.out.println("=======+============+=======+==============");
		// }
		// }
		// method recBinarySearch – to perform recursive binary search
		// public int recBinarySearch(ints[] ,int first, int last){
		// Arrays.sort(ints);
		// int newSearch = Lab3.search;
		// int middle = (first + last)/2;
		// if (last < first){
		// return -1;
		// }
		// if (newSearch == ints[middle]){
		// return middle;
		// }
		// else if (newSearch <ints[middle]){
		// return recBinarySearch(, first, ,middle -1 , newSearch);
		// }
		// int first , last , middle;
		// int newSearch = Lab3.search;
		// System.out.println(toString());
		// first = 0;
		// last = ints.length -1;

		// if (first < last){
		// middle = (first + last)/2;
		// if (newSearch < ints[middle]){
		//
		// }
		// }

		// public int recBinarySearch(int key, int l, int r) {
		// int newSearch = Lab3.search;
		// key = newSearch;
		// if (r < l) {
		// return -1;
		// }
		// //int mid is middle, key
		// int mid = (l + r) / 2;
		// if (key == ints[mid]) {
		// return mid;
		// }
		// if (key < ints[mid]) {
		// return recBinarySearch(key, l, mid - 1);
		// } else {
		// return recBinarySearch(key, mid + 1, r);
		// }
		// Arrays.sort(ints);
		// System.out.println("Testttt1");
		// int newSearch = Lab3.search;
		// int lower = 0;
		// int upper = ints.length - 1;
		// System.out.println("poop");
		//
		// while (lower <= upper) {
		//
		// int mid = lower + (upper - lower) / 2;
		//
		// if(newSearch < ints[mid])
		//
		// upper = mid - 1;
		//
		// else if (newSearch > ints[mid])
		//
		// lower = mid + 1;
		//
		//
		// else
		//
		// System.out.println("pop");
		// break;
		// }
		//
		// // return -1; // Returns -1 if no match is found
		// System.out.println("No match1");
		// }
		//
		// int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
		//
		// public int binarySearch(int key, int l, int r) {
		// if (r < l) {
		// return -1;
		// }
		// int mid = (l + r) / 2;
		// if (key == array[mid]) {
		// return mid;
		// }
		// if (key < array[mid]) {
		// return binarySearch(key, l, mid - 1);
		// } else {
		// return binarySearch(key, mid + 1, r);
		// }
		//
		// }
		//
		// public static void main(String[] args) {
		// BinarySearchRecTest b = new BinarySearchRecTest();
		//
		// for (int i = 2; i < 32; i += 2) {
		//
		// System.out.println("Search for element " + i);
		// System.out.println("This element is found at " + b.binarySearch(i, 0,
		// 14));
		// System.out.println("=======+============+=======+==============");
		// }
		// }
//	//hide this shit m8
//	public void recBinarySarch() {
//		Arrays.sort(ints);
//		//recQuickSort(ints, size, size);
//		int first, last, middle;
//		int newSearch = Lab4.search;
//		System.out.println(toString());
//		first = 0;
//		last = ints.length - 1;
//		middle = (first + last) / 2;
//		while (first <= last) {
//			if (ints[middle] < newSearch)
//				first = middle + 1;
//			else if (ints[middle] == newSearch) {
//				System.out.println(newSearch + " is in the list of numbers at the index " + (middle + 1) + ".");
//				break;
//			} // end of else if
//			else
//				last = middle - 1;
//			middle = (first + last) / 2;
//		} // end of while
//		if (first > last)
//			System.out.println(newSearch + " is not present in the list.\n");
//	}
//	
//	public int binSearch() {
//		 // change search after
//		//recQuickSort(ints, size, size);
//		Arrays.sort(ints);
//		int first, last, middle;
//		int newSearch = Lab4.search;
//		System.out.println(toString());
//		first = 0;
//		last = ints.length - 1;
//		middle = (first + last) / 2;
//
//		while (first <= last) {
//			if (ints[middle] == newSearch)
//				return middle;
//			else if (ints[middle] < newSearch)
//				first = middle + 1;
//			else
//				last = middle - 1;
//			middle = (first + last) / 2;
//		} // end of while
//		return -1;
//	}
//	
//	public void recQuickSorts(){
//		Arrays.sort(ints);
//	}
//
//	public int getSize() {
//		return size;
//	}
//
//	public void setSize(int size) {
//		this.size = size;
//	}
//	
//}


