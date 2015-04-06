package sort;

public class MergeSort {

	public void merge(int[] array, int p, int q, int r) {
		
		int n1 = q-p+1;
		int n2 = r-q;
		
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		for(int i=0; i<n1; i++) {
			L[i] = array[p+i];
		}
		
		for(int j=0; j<n2; j++) {
			R[j] = array[q+j+1];
		}
		
		int i = 0;
		int j = 0;
		
		for(int k=p; k<=r; k++) {
			if(L[i]<=R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
		}
	}
	
	public int[] mergeSort(int[] array, int p, int r) {
		
		int q;
		
		if(p<r) {
			q = (int)Math.floor((p+r)/2);
			mergeSort(array, p, q);
			mergeSort(array, q+1, r);
			merge(array,p,q,r);
		}
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + ",");
		}
		
		System.out.println("\n");
		
		return array;
		
	}
	
}
