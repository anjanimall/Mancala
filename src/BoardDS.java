
public class BoardDS {

	private int[][] pits;
	private int mancalaA;
	private int mancalaB;
	
	public BoardDS(){
		this.pits = new int[6][6];
		setMancalaA(0);
		setMancalaB(0);
	}
	
	public BoardDS(int num, int mancalaA, int mancalaB){
		this.setPits(num);
		this.setMancalaA(mancalaA);
		this.setMancalaB(mancalaB);
	}

	public int[][] getPits() {
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
