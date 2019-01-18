

public class PlayerTile {
	public int threat_level;
	public boolean clicked;
	public int value;
	public int row;
	public int col;

	public PlayerTile(int r, int c){
		threat_level = 0;
		clicked = false;
		value = 0;
		row = r;
		col = c;
	}



}