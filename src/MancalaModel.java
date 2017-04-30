import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class MancalaModel {

	private ArrayList<ChangeListener> listeners;
	private BoardDS pastBoard;
	private BoardDS currentBoard;
	private DesignComponent dc;

	public MancalaModel(BoardDS board) {
		this.listeners = new ArrayList<>();
		currentBoard = board;
		
	}

	public void attach(ChangeListener l) {
		listeners.add(l);
	}

	public void setPreviousBoard() {
		// TODO: Make the current board equal to the last board in the arraylist
		// and remove that board.
		// TODO: Notify all listeners of the change
	}

	public void update(int xIndex, int yIndex) {
		// TODO: This is where the game logic is implemented
		// TODO: Move the currentBoard to the pastBoards and assign new
		// currentBoard based on game logic.
		// TODO: Notify the listeners of change
	}
}
