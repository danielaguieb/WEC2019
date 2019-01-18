import java.util.Random;
import java.lang.Math;

public class Grid {

	// 1 is basin, 0 is clear
	public Tile[][] theGrid;
	public int gridBounds;
	public int num_basins;
	
	public Grid (int size) {
		theGrid = new Tile[size][size];
		gridBounds = size;
		randomizeBasins();
	}
	
	private void randomizeBasins() {
		
	}
	
	public int check(int row, int col) {
		theGrid[row][col].setClicked(true);
		
		if(theGrid[row][col].hasBasin())         
			// if chosen tile has a basin, immediate failure
			return -1;
		else {
			int basinCounter = 0;
			for(int N=row-1; N<3; N++) {
				for(int M=col-1; M<3; M++) {
					if(N>=0 && N < gridBounds && M>=0 && M < gridBounds) {
						if(theGrid[N][M].hasBasin())
							basinCounter++;
					}
				}
			}
			return basinCounter;
		}
	}
}
