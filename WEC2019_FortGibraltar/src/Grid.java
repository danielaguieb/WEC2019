import java.util.Random;
import java.lang.Math;

public class Grid {
	public Tile[][] theGrid;
	public int size;
	public int num_basins;
	
	public Grid (int n) {
		theGrid = new Tile[n][n];
		this.size = n;
		num_basins = (int) Math.sqrt(n);
		randomizeBasins();
	}
	
	private void randomizeBasins() {
		Random random = new Random();
		int rand_row = random.nextInt(size) + 1;
		int rand_col = random.nextInt(size) + 1;

		for(int i=0; i<num_basins; i++) {
			while(theGrid[rand_row][rand_col].hasBasin()) {
				rand_row = random.nextInt(size) + 1;
				rand_col = random.nextInt(size) + 1;
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
				if(N>=0 && N < size && M>=0 && M < size) {
					if(theGrid[N][M].hasBasin())
						basinCounter++;
				}
			}
		}
		return basinCounter;	
	}
	
	
	
	
}
