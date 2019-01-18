import java.util.Random;

public class Grid {
	public Tile[][] theGrid;
	public int sideLength;
	public int num_basins;
	
	public Grid (int n) {
		theGrid = new Tile[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				theGrid[i][j] = new Tile(); 
			}
		}
		sideLength = n;
		num_basins = n;
		randomizeBasins();
	}
	
	private void randomizeBasins() {
		Random random = new Random();
		int rand_row = random.nextInt(sideLength);
		int rand_col = random.nextInt(sideLength);

		for(int i=0; i<num_basins; i++) {
			while(theGrid[rand_row][rand_col].hasBasin()) {
				rand_row = random.nextInt(sideLength);
				rand_col = random.nextInt(sideLength);
			}
			
			theGrid[rand_row][rand_col].setBasin(true);
		}
	}
	
	public int check(int row, int col) {
		theGrid[row][col].setClicked(true);

		// if chosen tile has a basin, immediate failure
		if(theGrid[row][col].hasBasin())
			return -1;
		
		int basinCounter = 0;
		for(int N=row-1; N<3; N++) {
			for(int M=col-1; M<3; M++) {
				if(N>=0 && N < sideLength && M>=0 && M < sideLength) {
					if(theGrid[N][M].hasBasin())
						basinCounter++;
				}
			}
		}
		return basinCounter;	
	}
	
	/*
	 * Testing
	 * min: theSize = 3
	 * small: theSize = 10
	 * medium: theSize = 20
	 * large: theSize = 30
	 */
	public static void main(String[] args) {
		int theSize = 3;
		Grid theGame = new Grid(theSize);
		for(int i=0; i<theSize; i++) {
			for(int j=0; j<theSize; j++) {
				System.out.println(theGame.check(i,j));
			}
		}
	}
	
	
}
