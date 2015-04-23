package problems;

import java.util.ArrayList;

public class EditDistance {

	public static int diff(char a, char b) {

		if(a == b) {
			return 0;
		} else {
			return 1;
		}

	}

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
				System.out.print("    " + y[k] + "  ");
			} else{
				System.out.print(y[k] + "  ");
			}
		}

		int k=0;
		for(int i=0; i<=m; i++){

			if(i>0) {
				System.out.print(x[k] + "  ");
				k++;
			} else {
				System.out.print("   ");
			}


			for(int j=0; j<=n; j++){
				if(e[i][j]!= '\u2198'){
					System.out.print(op[i][j] + " ");
				} else {
					System.out.print(op[i][j] + " ");
				}

			}

			System.out.println();
		}
	}

	public static void printBacktrackMatrix(char[][] op, int[][] e, char[] x, char[] y) {

		int m = x.length;
		int n = y.length;

		char backtrack[][] = new char[m+1][n+1];

		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				backtrack[i][j] = '\u25e6'; //open bullet
			}
		}

		backtrack[m][n] = '\u2022';

		while(m!=0 && n!=0) {

			int a = e[m-1][n-1] + diff(x[m-1], y[n-1]);
			int b = e[m-1][n];
			int c = e[m][n-1];

			if(a <= Math.min(b, c)) {
				backtrack[m-1][n-1] = '\u2022'; //bullet
				m--; n--;
			} else {
				if(b <= c) {
					backtrack[m-1][n] = '\u2022';
					m--;
				} else {
					backtrack[m][n-1] = '\u2022';
					n--;

				}
			}

		}

		m = x.length;
		n = y.length;


		System.out.println("\nBACKTRACK MATRIX\n");

		for(int k=0; k<y.length; k++){
			if(k==0){
				System.out.print("     " + y[k] + " ");
			} else{
				System.out.print(y[k] + " ");
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
				System.out.print(backtrack[i][j] + " ");
			}

			System.out.println();
		}

		ArrayList<Character> resultX = new ArrayList<Character>();
		ArrayList<Character> resultY = new ArrayList<Character>();

		m=0; n=0;

		while(m!=x.length && n!=y.length) {
			if(backtrack[m][n+1]=='\u2022') {
				resultX.add('_');
				resultY.add(y[n]);
				n++;
			} else {
				if(backtrack[m+1][n+1]=='\u2022') {
					resultX.add(x[m]);
					resultY.add(y[n]);
					n++; m++;
				} else {
					resultX.add(x[m]);
					resultY.add('_');
					m++;
				}
			}
		}

		System.out.println("\nFINAL RESULT\n");

		System.out.print("Word 1: ");
		for(int i=0; i<resultX.size();i++) {
			System.out.print(resultX.get(i));
		}

		System.out.println();
		System.out.print("Word 2: ");
		for(int i=0; i<resultX.size();i++) {
			System.out.print(resultY.get(i));
		}
		
		System.out.println();

	}

	public static int edit(char[] x, char[] y) {

		int m = x.length;
		int n = y.length;

		int e[][] = new int[m+1][n+1];

		/*	Number 0 means diagonal arrow
		 * 	Number 1 means up arrow
		 * 	Number 2 means down arrow
		 */
		char op[][] = new char[m+1][n+1];

		for(int i = 0; i<=m; i++) {
			e[i][0] = i;
		}

		for(int j = 0; j<=n; j++) {
			e[0][j] = j;
		}

		for(int i=1; i<=m; i++) {

			for(int j=1; j<=n; j++) {

				int a = e[i-1][j-1] + diff(x[i-1], y[j-1]);
				int b = e[i-1][j] + 1;
				int c = e[i][j-1] + 1;

				if(a <= Math.min(b, c)) {
					e[i][j] = a;
					op[i][j] = '\u2198';	//south east arrow
				} else {
					if(b <= c) {
						e[i][j] = b;
						op[i][j] = '\u2193';	//downwards arrow
					} else {
						e[i][j] = c;
						op[i][j] = '\u2191';	//upwards arrow
					}
				}
			}
		}

		printEditMatrix(op, e, x, y);
		printArrowMatrix(op, e, x, y);
		printBacktrackMatrix(op, e, x, y);

		return e[m][n];

	}

	public static void main(String [ ] args) {

		String a = "SUNNY";
		String b = "SNOWY";

		char[] x = a.toCharArray();
		char[] y = b.toCharArray();

		int result;

		result = edit(x,y);

		System.out.println();
		System.out.println("Number of operations: " + result);


	}

}
