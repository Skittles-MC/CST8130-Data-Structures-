import java.util.Arrays;
import java.util.Random;

public class Numbers {


	//Integer ints[];
	private int[] ints = null;
	int size;

	// default constructor
	// initial constructor using an int parameter to set size of the array
	Numbers() {
		size = 0;
		this.ints = new int[size];
	}
	Numbers(int num) {
		size = num;
		ints = new int[size];
	}
	/*
	 * method generateNumbers – which will use the Random class to fill the
	 * array with random numbers between 1 and 50.
	 */
	public void generateNumbers() {
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			ints[i] = r.nextInt(50) + 1;
		}
	}
	/*
	 * method count – will return an int which is a count of the number of
	 * occurrances of a parameter int contained in the array
	 */
	public int count(int num) {
		int counter = 0;
		for (int i = 0; i < size; i++) {
			if (num == ints[i]) {
				counter++;
			}
		}
		return counter;
	}
	
	// method toString – will return a String of the values in the array
	public String toString() {
		return Arrays.toString(ints);
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

}