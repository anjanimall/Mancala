import java.util.ArrayList;

public class BoardDS {

	//private int[][] pits;
	private ArrayList<Pit> pits;
	private int mancalaA; //right
	private int mancalaB; //left
	private boolean playerOne;
	
	public BoardDS(){
		//this.pits = new int[6][6];
		pits = new ArrayList<Pit>();
		setMancalaA(0);
		setMancalaB(0);
		playerOne = true;//player one turn on true
	}
	
	public ArrayList<Pit> getPits() {
		return pits;
	}

	public void setPits(int num) {
		for(int i = 0; i<6; i++){
			for(int j = 0; j<2; j++){
				pits[i][j] = num;
			}
		}
	}

	public int getMancalaA() {
		return mancalaA;
	}

	public void setMancalaA(int mancalaA) {
		this.mancalaA = mancalaA;
	}

	public int getMancalaB() {
		return mancalaB;
	}

	public void setMancalaB(int mancalaB) {
		this.mancalaB = mancalaB;
	}
}
