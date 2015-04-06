package sort;

public class InsertionSort {

	public int[] insert(int[] array) {
		
		int key, i;
		
		for(int j = 1; j< array.length; j++) {
			key = array[j];
			i = j-1;
			while(i>0 && array[i]>key) {
				array[i+1] = array[i];
				i = i-1;
				
			}
			
			array[i+1] = key;
		}
		
		for(int k=0; k<array.length; k++) {
			System.out.print(array[k] + ",");
		}
		
		System.out.println("\n");
		
		return array;
		
	}
	
}
