import java.util.ArrayList;

public class BoardDS {


	private ArrayList<Integer> pits;
	private int mancalaA; //right
	private int mancalaB; //left
	
	public BoardDS(){
		//this.pits = new int[6][6];
		pits = new ArrayList<Integer>();
		setMancalaA(0);
		setMancalaB(0);
	}
	
	public BoardDS(ArrayList<Integer> p , int mancalaA, int mancalaB){
		pits = p;
		this.mancalaA = mancalaA;
		this.mancalaB = mancalaB;
	}
	
	public ArrayList<Integer> getPits() {
		return pits;
	}

	public void setPits(int num) {
		for(int i = 0; i<12; i++){
			pits.add(num);
		}
	}

	public int getMancalaA() {
		return mancalaA;
	}

	public void setMancalaA(int mA) {
		this.mancalaA = mA;
	}

	public int getMancalaB() {
		return mancalaB;
	}

	public void setMancalaB(int mB) {
		this.mancalaB = mB;
	}
}