import java.util.*;
import javax.swing.event.*;

/**
 * Model class of the MVC architecture
 * @author Setty, Mallampati, Elmoghany
 */
public class MancalaModel {

	private ArrayList<ChangeListener> listeners;
	private BoardDS pastBoard;
	private BoardDS currentBoard;
	static Winners winner = Winners.inProgress;
	private boolean pastMancala = false;
	private boolean pastTurnA = true;
	private int countA = 0;
	private int countB = 0;

	/**
	 * Creates a MancalaModel object
	 * @param board the BoardDS object
	 */
	public MancalaModel(BoardDS board) {
		this.listeners = new ArrayList<>();
		currentBoard = board;
	}

	/**
	 * Attaches a ChangeListener to the ArrayList of ChangeListeners
	 * @param l ChangeListener
	 */
	public void attach(ChangeListener l) {
		listeners.add(l);
	}
	
	/**
	 * Gets the current board
	 * @return the currentBoard
	 */
	public BoardDS getBoard(){
		return currentBoard;
	}

	/**
	 * Sets the previous board
	 * Undo functionality
	 */
	public void setPreviousBoard() {
		// TODO: Make the current board equal to the last board in the arraylist
		// and remove that board.
		// TODO: Notify all listeners of the change
		 
		if(countA > 2 && !pastTurnA) {
			countA = 0;
		} else if(countB > 2 && pastTurnA) {
			countB = 0;
		}
		
		if(countA > 2 || countB > 2) {
			return;
		}
		
		if(pastTurnA) {
			countA++;
		} else if(!pastTurnA) {
			countB++;
		}

		//System.out.println("CountA: " + countA);
		//System.out.println("CountB: " + countB);
		
		if(!pastMancala) {
			MancalaTest.turn = !MancalaTest.turn;
		}
		ArrayList<Integer> pits2 = new ArrayList<>();
		for(int i = 0; i < 12; i++){
			pits2.add(pastBoard.getPits().get(i));
		}
		currentBoard = new BoardDS(pits2, pastBoard.getMancalaA(), pastBoard.getMancalaB());
		
		//System.out.println(currentBoard.getPits());
		
		for(ChangeListener l: listeners){
			l.stateChanged(new ChangeEvent(this));
		}
	}

	/**
	 * Updates the board according to the user selection
	 * Game logic is implemented
	 * Notifies Listeners of change
	 * @param index the index of the selected pit
	 * @param playerA the player
	 * @return true/false if the pebble landed in the players' mancala
	 */
	public boolean update(int index, boolean playerA) {
		//System.out.println(index);
		ArrayList<Integer> pits2 = new ArrayList<>();
		for(int i = 0; i < 12; i++){
			pits2.add(currentBoard.getPits().get(i));
		}
		pastBoard = new BoardDS(pits2, currentBoard.getMancalaA(), currentBoard.getMancalaB());
		
		ArrayList<Integer> values = currentBoard.getPits();
		int currentVal = values.get(index);
		if(currentVal == 0) {
			return playerA;
		}
		values.set(index, 0);
		index += 1;
		boolean first = true;
		boolean inMancala = false;
		int end = index;
		for(int i = 1; i <= currentVal; i++){ //i num of stones
			if(playerA) {
				pastTurnA = true;
				if(index <= 11) {
					values.set(index, (values.get(index))+1);
					inMancala = false;
					end = index;
					index++;
				} else {
					currentBoard.setMancalaA((currentBoard.getMancalaA())+1);
					inMancala = true;
					end = -1;
					index = 0;
				}
			} else {
				pastTurnA = false;
				if(first && index == 6) {
					first = false;
					currentBoard.setMancalaB((currentBoard.getMancalaB())+1);
					inMancala = true;
					end = -1;
				} else if((index == 5 && i+1 <= currentVal)) {
					first = false;
					values.set(index, (values.get(index))+1);
					currentBoard.setMancalaB((currentBoard.getMancalaB())+1);
					inMancala = true;
					i++;
					end = -1;
					index = 6;
				} else if(index <= 11) {
					values.set(index, (values.get(index))+1);
					inMancala = false;
					end = index;
					index++;
				} else {
					values.set(0, (values.get(0))+1);
					inMancala = false;
					end = 0;
					index = 1;
				}
			}
		}
		
		if(inMancala) {
			pastMancala = true;
		} else {
			pastMancala = false;
		}
		
		if(playerA && end > 5 && end < 12) {
			if(values.get(end) == 1) {
				int opposite = 5 - (end - 6);
				int collect = values.get(opposite);
				currentBoard.setMancalaA((currentBoard.getMancalaA()) + collect);
				values.set(opposite, 0);
			}
		} else if(!playerA && end >= 0 && end < 6) {
			if(values.get(end) == 1) {
				int opposite = 11 - end;
				int collect = values.get(opposite);
				currentBoard.setMancalaB((currentBoard.getMancalaB()) + collect);
				values.set(opposite, 0);
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 6; i++) {
			sum += values.get(i);
		}
		
		if(sum == 0) {
			for(int i = 6; i < 12; i++) {
				currentBoard.setMancalaA((currentBoard.getMancalaA() + values.get(i)));
				values.set(i, 0);
			}
		}
		
		sum = 0;
		for(int i = 6; i < 12; i++) {
			sum += values.get(i);
		}
		if(sum == 0) {
			for(int i = 0; i < 6; i++) {
				currentBoard.setMancalaB((currentBoard.getMancalaB() + values.get(i)));
				values.set(i, 0);
			}
		}
		
		if(sum == 0) {
			if(currentBoard.getMancalaA() > currentBoard.getMancalaB()) {
				winner = Winners.winnerA;
			} else if (currentBoard.getMancalaA() == currentBoard.getMancalaB()) {
				winner = Winners.draw;
			} else {
				winner = Winners.winnerB;
			}
		}
		
		for(ChangeListener l: listeners){
			l.stateChanged(new ChangeEvent(this));
		}
		return inMancala;
	}
}