import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel {

	private ArrayList<ChangeListener> listeners;
	private BoardDS pastBoard;
	private BoardDS currentBoard;

	public MancalaModel(BoardDS board) {
		this.listeners = new ArrayList<>();
		currentBoard = board;
		
	}

	public void attach(ChangeListener l) {
		listeners.add(l);
	}
	
	public BoardDS getBoard(){
		return currentBoard;
	}

	public void setPreviousBoard() {
		// TODO: Make the current board equal to the last board in the arraylist
		// and remove that board.
		// TODO: Notify all listeners of the change
	}

	public void update(int index) {
		System.out.println(index);
		ArrayList<Integer> values = currentBoard.getPits();
		int currentVal = values.get(index);
		values.set(index, 0);
		index +=1;
		for(int i = 1; i<=currentVal; i++){
			if(index+i>11){
				index=0;
			}
			values.set(index, values.get(index)+1);
			index++;
		}
		
		for(ChangeListener l: listeners){
			l.stateChanged(new ChangeEvent(this));
		}
		// TODO: This is where the game logic is implemented
		// TODO: Move the currentBoard to the pastBoards and assign new
		// currentBoard based on game logic.
		// TODO: Notify the listeners of change
	}
}