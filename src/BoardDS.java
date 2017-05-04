import java.util.*;

/**
 * 
 * @author Setty, Mallampati, Elmoghany
 *
 */
public class BoardDS {
	
	private ArrayList<Integer> pits;
	private int mancalaA; //right
	private int mancalaB; //left
	
	/**
	 * 
	 */
	public BoardDS(){
		pits = new ArrayList<Integer>();
		setMancalaA(0);
		setMancalaB(0);
	}
	
	/**
	 * 
	 * @param p
	 * @param mancalaA
	 * @param mancalaB
	 */
	public BoardDS(ArrayList<Integer> p , int mancalaA, int mancalaB){
		pits = p;
		this.mancalaA = mancalaA;
		this.mancalaB = mancalaB;
	}

	/**
	 * Gets the Integer ArrayList of Pits
	 * Used in DesignComponent to draw the pits
	 * @return pits
	 */
	public ArrayList<Integer> getPits() {
		return pits;
	}

	/**
	 * Sets the number of pebbles in each pit
	 * Initially, either 3 or 4 pebbles based on the user selection
	 * @param num the number of pebbles
	 */
	public void setPits(int num) {
		for(int i = 0; i < 12; i++){
			pits.add(num);
		}
	}

	/**
	 * Gets Mancala A
	 * Used in DesignComponent to draw Mancala A
	 * Used in MancalaModel to get the number of pebbles in Mancala A
	 * @return mancalaA
	 */
	public int getMancalaA() {
		return mancalaA;
	}

	/**
	 * Sets Mancala A to contain the given number of pebbles
	 * @param mA the number of pebbles to put in Mancala A
	 */
	public void setMancalaA(int mA) {
		this.mancalaA = mA;
	}

	/**
	 * Gets Mancala B
	 * Used in DesignComponent to draw Mancala B
	 * Used in MancalaModel to get the number of pebbles in Mancala B
	 * @return mancalaB
	 */
	public int getMancalaB() {
		return mancalaB;
	}

	/**
	 * Sets Mancala B to contain the given number of pebbles
	 * @param mB the number of pebbles to put in Mancala B
	 */
	public void setMancalaB(int mB) {
		this.mancalaB = mB;
	}
}