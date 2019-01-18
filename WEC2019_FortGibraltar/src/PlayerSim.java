import java.util.Random;
import java.util.ArrayList;

public class PlayerSim {
	public PlayerTile[][] PlayerTile;
	public int sideLength;
	public int curr_threat_level;

	public PlayerSim(int sideLength){
		this.sideLength = sideLength;
		curr_threat_level = 0;
		for(int i=0; i < sideLength; i++) {
			for(int j=0; j< sideLength; j++) {
				PlayerTile[i][j] = new PlayerTile(i,j); 
			}
		}
	}

	public void makeFirstMove(){
		Random rand = new Random();
		int rand_row = rand.nextInt(sideLength);
		int rand_col = rand.nextInt(sideLength);
		// to send coords
		// recieve info

		if(PlayerTile[rand_row][rand_col].value == -1){
			//LOST
		}

		play(rand_row, rand_col);
		if(PlayerTile[rand_row][rand_col].value == 0)
			zeroPick(rand_row, rand_col);
	}

	public void play(int row, int col){

		PlayerTile[row][col].clicked = true;
		PlayerTile[row][col].threat_level = 0;
		for(int i=row-1; i<row+2; i++){
			for(int j=col-1; j<col+2; j++){
				if(i>=0 && i < sideLength && j>=0 && j < sideLength
				   && PlayerTile[i][j].clicked == false)
					PlayerTile[i][j].threat_level += PlayerTile[row][col].value;
			}
		}
	}

	public void nextMoves(){
		ArrayList<PlayerTile> lowestTiles = new ArrayList<PlayerTile>();

		for(int i=0; i< sideLength; i++) {
			for(int j=0; j< sideLength; j++) {
				if(PlayerTile[i][j].threat_level < curr_threat_level){
					curr_threat_level = PlayerTile[i][j].threat_level;
				}
			}
		}

		for(int i=0; i< sideLength; i++) {
			for(int j=0; j< sideLength; j++) {
				if(PlayerTile[i][j].threat_level == curr_threat_level){
					lowestTiles.add(PlayerTile[i][j]);
				}
			}
		}

		Random rand = new Random();
		int nextTile = rand.nextInt(lowestTiles.size());
		PlayerTile temp = lowestTiles.get(nextTile);
		play(temp.row, temp.col);
		lowestTiles.remove(nextTile);

	}

// if a slected box is surrounded by no basins, then auto select all
// the surrounding tiles	
	private void zeroPick(int row, int col){
		for(int i=row-1; i<row+2; i++){
			for(int j=col-1; j<col+2; j++){
				if(i>=0 && i < sideLength && j>=0 && j < sideLength
				   && PlayerTile[i][j].clicked == false)
					play(i,j);
			}
		}
	}

	public void send(int row, int col){

	}


}