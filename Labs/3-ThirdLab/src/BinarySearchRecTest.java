
public class BinarySearchRecTest {


	    int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};

	    public int binarySearch(int key, int l, int r) {
	        if (r < l) {
	            return -1;
	        }
	        int mid = (l + r) / 2;
	        if (key == array[mid]) {
	            return mid;
	        }
	        if (key < array[mid]) {
	            return binarySearch(key, l, mid - 1);
	        } else {
	            return binarySearch(key, mid + 1, r);
	        }

	    }

	    public static void main(String[] args) {
	    	BinarySearchRecTest b = new BinarySearchRecTest();

	        for (int i = 2; i < 32; i += 2) {

	            System.out.println("Search for element " + i);
	            System.out.println("This element is found at " + b.binarySearch(i, 0, 14));
	            System.out.println("=======+============+=======+==============");
	        }
	    }
	}

