package sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {
	
	int[] testingArray = {0,5,1,4,2,3};
	
	@Test
	public void testMergeSort() {

		MergeSort mg = new MergeSort();
		
		System.out.println( mg.mergeSort(testingArray, 0, 5).toString());
		
	}
	
	@Test
	public void testInsertionSort() {
		System.out.println("Insertion Sort");
		InsertionSort is = new InsertionSort();
		is.insert(testingArray);
	}

}
