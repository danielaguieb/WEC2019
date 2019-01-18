
public class Tile {

	private boolean basin;
	private boolean clicked;
	
	public Tile() {
		basin = false;
		clicked = false;
	}
	
	public boolean hasBasin() {
		return basin;
	}

	public void setBasin(boolean hasBasin) {
		this.basin = hasBasin;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	
	

	
}
