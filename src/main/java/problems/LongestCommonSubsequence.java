package problems;

public class LongestCommonSubsequence {

	public static void printEditMatrix(char[][] op, int[][] e, char[] x, char[] y) {

		System.out.println("EDIT MATRIX");
		
		int m = x.length;
		int n = y.length;

		System.out.println();

		for(int k=0; k<y.length; k++){
			if(k==0){
				System.out.print("      " + y[k] + "  ");
			} else{
				System.out.print(y[k] + "  ");
			}
		}
		System.out.println();

		int k=0;
		for(int i=0; i<=m; i++){

			if(i>0) {
				System.out.print(x[k] + "  ");
				k++;
			} else {
				System.out.print("   ");
			}


			for(int j=0; j<=n; j++){
				if(e[i][j]< 10){
					System.out.print(e[i][j] + "  ");
				} else {
					System.out.print(e[i][j] + " ");
				}

			}

			System.out.println();
		}

	}
	
	
	public static void printArrowMatrix(char[][] op, int[][] e, char[] x, char[] y) {

		int m = x.length;
		int n = y.length;

		System.out.println("\nARROW MATRIX\n");

		for(int k=0; k<y.length; k++){
			if(k==0){
				System.out.print("   " + y[k] + " ");
			} else{
				System.out.print(y[k] + " ");
			}
		}

		int k=0;
		System.out.println();
		for(int i=0; i<m; i++){

			if(i>0) {
				System.out.print(x[k] + "  ");
				k++;
			} else {
				System.out.print("   ");
			}
			

			for(int j=0; j<n; j++){
				if(e[i][j]!= '\u2198'){
					System.out.print(op[i][j] + " ");
				} else {
					System.out.print(op[i][j] + " ");
				}

			}

			System.out.println();
		}
	}
	
	public static void printLCS(char[][] b, char[] x, int i, int j) {
		
		if(i==0 || j==0) {
			return;
		}
		
		if(b[i-1][j-1] == '\u2196') {
			printLCS(b, x, i-1, j-1);
			System.out.print(x[i-1]);
		} else {
			if(b[i-1][j-1] == '\u2191') {
				printLCS(b, x, i-1, j);
			} else {
				printLCS(b, x, i, j-1);
			}
		}
	}
	
	public static void LCSLength(char[] x, char[] y) {
		
		int m = x.length;
		int n = y.length;
		
		char b[][] = new char[m][n];
		int c[][] = new int[m+1][n+1];
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(x[i-1]==y[j-1]) {
					c[i][j] = c[i-1][j-1] + 1;
					b[i-1][j-1] = '\u2196';		//diagonal
				} else {
					if (c[i-1][j]>=c[i][j-1]) {
						c[i][j] = c[i-1][j];
						b[i-1][j-1] = '\u2191';	//upwards
					} else {
						c[i][j] = c[i][j-1];
						b[i-1][j-1] = '\u2190'; //leftwards
					}
				}
			}
		}
		
		printEditMatrix(b, c, x, y);
		printArrowMatrix(b, c, x, y);
		System.out.print("\nLongest Common Subsequence: ");
		printLCS(b, x, x.length, y.length);
		System.out.println();
	}
	
	public static void main(String [ ] args) {
		
		String a = "ABCBDAB";
		String b = "BDCABA";

		char[] x = a.toCharArray();
		char[] y = b.toCharArray();

		LCSLength(x,y);

	}
	
}
