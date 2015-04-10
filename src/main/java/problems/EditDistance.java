package problems;

public class EditDistance {

	public int diff(int a, int b) {
		
		if(a == b) {
			return 0;
		} else {
			return 1;
		}
	
	}
	
	public int edit(int[] x, int[] y) {
	
		int m = x.length;
		int n = y.length;
		
		int e[][] = new int[m][n];
		
		for(int i = 0; i<m; i++) {
			e[i][0] = i;
		}
		
		for(int j = 0; j<n; j++) {
			e[0][j] = j;
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				
				int a = e[i-1][j-1] + diff(x[i], x[j]);
				int b = e[i-1][j] + 1;
				int c = e[i][j-1] + 1;
				
				if(a <= Math.min(b, c)) {
					e[i][j] = a;
				} else {
					if(b <= c){
						e[i][j] = b;
					} else {
						e[i][j] = c;
					}
					
				}
				
			}
		}
		
		return e[m][n];
		
	}
	
	public static void main(String [ ] args) {
		
	}
	
}
